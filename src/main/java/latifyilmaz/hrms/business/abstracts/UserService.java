package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.dataAccess.abstracts.UserDao;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.user.UserLoginDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //Get
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByEmail(String email);
    DataResult<?> getUserTypeByEmail(String email);
    DataResult<User> getByEmailAndPassword(String email, String password);

    //Post
    Result save(User user);
    Result verifyById(int id);
    Result verifyByEmail(String email);
    DataResult<?> login(UserLoginDto user);

    //Delete
    Result delete(User user);
    Result deleteById(int id);
}
