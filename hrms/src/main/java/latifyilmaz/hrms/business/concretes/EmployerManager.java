package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.EmployerDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailService emailService;
    private String FIELD = "employer";

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService emailService){
        super();
        this.employerDao = employerDao;
        this.emailService = emailService;
    }

    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(this.employerDao.getByEmail(email), MessageResults.dataListed(FIELD));
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
        boolean checkEmail = emailService.checkWithDomain(employer.getEmail(), employer.getEmail()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

       Employer byEmail = getByEmail(employer.getEmail()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        Employer employerObject = new Employer(
                employer.getEmail(),
                employer.getPassword(),
                false,
                employer.getCompanyName(),
                employer.getWebsite(),
                employer.getPhone(),
                false
        );

        this.employerDao.save(employerObject);
        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmailBySystem));
    }
}
