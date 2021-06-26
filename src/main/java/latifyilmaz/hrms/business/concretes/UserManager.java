package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.UserDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.concretes.Personnel;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.user.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;
    private final EmployeeService employeeService;
    private final EmployerService employerService;
    private final PersonnelService personnelService;
    private final String FIELD = "user";

    @Autowired
    public UserManager(UserDao userDao, @Lazy EmployeeService employeeService, @Lazy EmployerService employerService, @Lazy PersonnelService personnelService){
        this.userDao = userDao;
        this.employeeService = employeeService;
        this.employerService = employerService;
        this.personnelService = personnelService;
    }


    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<User> getByEmail(String email) {
        User user = this.userDao.getByEmail(email);
        if(user == null){
            return new ErrorDataResult<User>(MessageResults.notFound(FIELD));
        }
        return new SuccessDataResult<User>(user, MessageResults.dataListed(FIELD));
    }

    public DataResult<User> getByEmailAndPassword(String email, String password) {
        User user = this.userDao.getByEmailAndPassword(email, password);
        if(user == null){
            return new ErrorDataResult<User>(MessageResults.notFound(FIELD));
        }
        return new SuccessDataResult<User>(user, MessageResults.dataListed(FIELD));

    }

    public Result save(User user) {
        if(StringTools.isStringNullOrEmpty(user.getEmail()) ||
                StringTools.isStringNullOrEmpty(user.getPassword())){
            return new ErrorResult(MessageResults.emptyField);
        }

        this.userDao.save(user);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result verifyById(int id) {
        User user = getById(id).getData();
        if(user == null){
            return new ErrorResult(MessageResults.verificationSuccessFalse);
        }

        user.setVerified(true);
        this.userDao.save(user);
        return new SuccessResult(MessageResults.verificationSuccessTrue);
    }

    public Result verifyByEmail(String email) {
        User user = getByEmail(email).getData();
        if(user == null){
            return new ErrorResult(MessageResults.verificationSuccessFalse);
        }

        user.setVerified(true);
        this.userDao.save(user);
        return new SuccessResult(MessageResults.verificationSuccessTrue);
    }

    public DataResult<?> login(UserLoginDto user) {
        DataResult<User> findUser = getByEmailAndPassword(user.getEmail(), user.getPassword());
        if(!findUser.isSuccess()){
            return new ErrorDataResult<>(MessageResults.emailOrPasswordWrong);
        }

        //DataResult<Employee> findEmployee = employeeService.getById(findUser.getData().getId());
        //DataResult<Employer> findEmployer = employerService.getById(findUser.getData().getId());
        //DataResult<Personnel> findPersonnel = personnelService.getById(findUser.getData().getId());

        return null;
    }

    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.userDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
