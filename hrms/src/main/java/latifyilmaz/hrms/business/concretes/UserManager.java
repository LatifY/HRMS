package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.UserDao;
import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private final UserDao userDao;
    private final String FIELD = "user";

    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }


    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email), MessageResults.dataListed(FIELD));
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

    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.userDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
