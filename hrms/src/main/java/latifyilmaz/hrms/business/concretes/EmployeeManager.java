package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.adapters.abstracts.UserCheckService;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.EmployeeDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final UserCheckService userCheckService;
    private final EmailService emailService;
    private final String FIELD = "employee";

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, UserCheckService userCheckService, EmailService emailService){
        super();
        this.employeeDao = employeeDao;
        this.userCheckService = userCheckService;
        this.emailService = emailService;
    }

    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result save(String firstName, String lastName, String tcNo, int dateOfBirthYear, String email, String password, String passwordRetry) {
        //Field Check
        if (StringTools.isStringNullOrEmpty(firstName) ||
            StringTools.isStringNullOrEmpty(lastName) ||
            StringTools.isStringNullOrEmpty(tcNo) ||
            StringTools.isStringNullOrEmpty(String.valueOf(dateOfBirthYear)) ||
            StringTools.isStringNullOrEmpty(email) ||
            StringTools.isStringNullOrEmpty(password) ||
            StringTools.isStringNullOrEmpty(passwordRetry)){
            return new ErrorResult(MessageResults.emptyFields);
        }

        if(password != passwordRetry){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }


        //Check if real person
        boolean checkRealPerson = userCheckService.isRealPerson(tcNo,firstName,lastName,dateOfBirthYear);
        if(!checkRealPerson){
            return new ErrorResult(MessageResults.isRealPersonFalse);
        }

        //Check Email Format
        boolean checkEmail = emailService.check(email).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

        DataResult<Employee> findByEmail = employeeDao.findByEmail(email);
        DataResult<Employee> findByTcNo = employeeDao.findByEmail(tcNo);

        if(findByEmail.getData() != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        if(findByTcNo.getData() != null){
            return new ErrorResult(MessageResults.alreadyExists("tcNo"));
        }

        Employee employee = new Employee(firstName,lastName, tcNo, dateOfBirthYear, email, password);

        this.employeeDao.save(employee);
        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmail));
    }
}
