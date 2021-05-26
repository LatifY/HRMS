package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.EmployerDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Employer;
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

    public Result save(String companyName, String website, String phone, String email, String password, String passwordRetry) {
        //Field Check
        if(StringTools.isStringNullOrEmpty(companyName) ||
                StringTools.isStringNullOrEmpty(website) ||
                StringTools.isStringNullOrEmpty(phone) ||
                StringTools.isStringNullOrEmpty(email) ||
                StringTools.isStringNullOrEmpty(password) ||
                StringTools.isStringNullOrEmpty(passwordRetry)){
            return new ErrorResult(MessageResults.emptyFields);
        }

        if(password != passwordRetry){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        //Check Email Format
        boolean checkEmail = emailService.checkWithDomain(email, website).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

        DataResult<Employer> findByEmail = employerDao.findByEmail(email);

        if(findByEmail.getData() != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        Employer employer = new Employer(companyName, website, phone, false, email, password);
        this.employerDao.save(employer);
        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmailBySystem));
    }
}
