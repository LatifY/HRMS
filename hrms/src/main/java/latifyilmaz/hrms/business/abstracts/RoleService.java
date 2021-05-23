package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Role;

import java.util.List;

public interface RoleService {
    DataResult<List<Role>> getAll();
    DataResult<Role> getById(int id);
}
