package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {
    /*
    //Save (POST)
    DataResult<User> save(User user);

    //Delete (DELETE)
    DataResult<User> delete(User user);
    DataResult<Integer> deleteById(int id);

    //Update (PUT)
    DataResult<User> update(User user);
    */

    //Get (GET)
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
}
