package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.adapters.abstracts.UserCheckService;
import latifyilmaz.hrms.core.adapters.concretes.FakeMernisServiceAdapter;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.EmployeeDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeSaveDto;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeUpdateDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {
    private final EmployeeDao employeeDao;
    private final UserService userService;
    private final ResumeService resumeService;
    private final PositionService positionService;
    private final UserCheckService userCheckService = new FakeMernisServiceAdapter();
    private final EmailService emailService;
    private final String FIELD = "employee";

    public EmployeeManager(EmployeeDao employeeDao, PositionService positionService, UserService userService, ResumeService resumeService, EmailService emailService){
        super();
        this.employeeDao = employeeDao;
        this.positionService = positionService;
        this.userService = userService;
        this.resumeService = resumeService;
        this.emailService = emailService;
    }

    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Employee> getByEmail(String email) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByUser_Email(email));
    }

    public DataResult<Employee> getByIdentityNo(String identityNo) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByIdentityNo(identityNo));
    }

    public Result save(EmployeeSaveDto employee) {
        //Field Check
        if (StringTools.isStringNullOrEmpty(employee.getFirstName()) ||
            StringTools.isStringNullOrEmpty(employee.getLastName()) ||
            StringTools.isStringNullOrEmpty(employee.getIdentityNo()) ||
            StringTools.isStringNullOrEmpty(String.valueOf(employee.getBirthYear())) ||
            StringTools.isStringNullOrEmpty(employee.getEmail()) ||
            StringTools.isStringNullOrEmpty(employee.getPassword()) ||
            StringTools.isStringNullOrEmpty(employee.getPasswordRetry()) ||
            StringTools.isStringNullOrEmpty(String.valueOf(employee.getPositionId()))){
            return new ErrorResult(MessageResults.emptyFields);
        }

        if(!employee.getPassword().equals(employee.getPasswordRetry())){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        //Check if real person
        boolean checkRealPerson = userCheckService.isRealPerson(employee.getIdentityNo(),employee.getFirstName(),employee.getLastName(),employee.getBirthYear());
        if(!checkRealPerson){
            return new ErrorResult(MessageResults.isRealPersonFalse);
        }


        //Check Email Format
        boolean checkEmail = emailService.check(employee.getEmail()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

        User byEmail = userService.getByEmail(employee.getEmail()).getData();
        Employee byIdentityNo = getByIdentityNo(employee.getIdentityNo()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        if(byIdentityNo != null){
            return new ErrorResult(MessageResults.alreadyExists("identityNo"));
        }

        User user = new User(
                employee.getEmail(),
                employee.getPassword(),
                false,
                "employee"
        );
        userService.save(user);

        Position position = positionService.getById(employee.getPositionId()).getData();

        Employee employeeObject = new Employee(
                user.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getIdentityNo(),
                employee.getBirthYear(),
                position
        );
        this.employeeDao.save(employeeObject);

        return new SuccessResult(MessageResults.saved(FIELD, MessageResults.validateEmail));
    }

    public Result updateById(EmployeeUpdateDto employee) {
        Position position = positionService.getById(employee.getPositionId()).getData();
        this.employeeDao.updateById(employee.getUserId(), employee.getFirstName(), employee.getLastName(), employee.getBirthYear(), position);
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result delete(Employee employee) {
        this.employeeDao.delete(employee);
        this.userService.delete(employee.getUser());
        Resume resume = resumeService.getByEmployeeId(employee.getUserId()).getData();
        if(resume != null){
            resumeService.deleteById(resume.getId());
        }

        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.employeeDao.deleteById(id);
        this.userService.deleteById(id);
        Resume resume = resumeService.getByEmployeeId(id).getData();
        if(resume != null){
            resumeService.deleteById(resume.getId());
        }

        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
