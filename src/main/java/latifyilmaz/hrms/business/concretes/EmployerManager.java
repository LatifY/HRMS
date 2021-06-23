package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.EmployerDao;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final UserService userService;
    private final EmailService emailService;
    private final String FIELD = "employer";

    @Autowired
    public EmployerManager(EmployerDao employerDao, UserService userService, EmailService emailService){
        super();
        this.employerDao = employerDao;
        this.userService = userService;
        this.emailService = emailService;
    }

    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByUser_Email(email), MessageResults.dataListed(FIELD));
    }

    public Result save(EmployerSaveDto employer) {
        //Field Check
        if(StringTools.isStringNullOrEmpty(employer.getCompanyName()) ||
                StringTools.isStringNullOrEmpty(employer.getWebsite()) ||
                StringTools.isStringNullOrEmpty(employer.getPhone()) ||
                StringTools.isStringNullOrEmpty(employer.getEmail()) ||
                StringTools.isStringNullOrEmpty(employer.getPassword()) ||
                StringTools.isStringNullOrEmpty(employer.getPasswordRetry())){
            return new ErrorResult(MessageResults.emptyFields);
        }


        if(!employer.getPassword().equals(employer.getPasswordRetry())){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        //Check Email Format
        boolean checkEmail = emailService.checkWithDomain(employer.getEmail(), employer.getWebsite()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

       Employer byEmail = getByEmail(employer.getEmail()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        User user = new User(
                employer.getEmail(),
                employer.getPassword(),
                false
        );
        userService.save(user);

        Employer employerObject = new Employer(
                user.getId(),
                employer.getCompanyName(),
                employer.getWebsite(),
                employer.getPhone(),
                false
        );
        this.employerDao.save(employerObject);
        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmailBySystem));
    }

    public Result delete(Employer employer) {
        this.employerDao.delete(employer);
        this.userService.delete(employer.getUser());
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.employerDao.deleteById(id);
        this.userService.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
