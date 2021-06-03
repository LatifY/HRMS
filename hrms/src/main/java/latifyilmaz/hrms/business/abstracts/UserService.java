package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.dataAccess.abstracts.UserDao;
import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //Get
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByEmail(String email);

    Result save(User user);
    Result verifyById(int id);
    Result verifyByEmail(String email);
}
