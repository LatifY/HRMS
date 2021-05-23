package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.RoleService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.RoleDao;
import latifyilmaz.hrms.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleManager implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleManager(RoleDao roleDao){
        super();
        this.roleDao = roleDao;
    }


    //Get
    public DataResult<List<Role>> getAll() {
        return new SuccessDataResult<List<Role>>(this.roleDao.findAll(), "All Role data listed.");
    }

    public DataResult<Role> getById(int id) {
        return new SuccessDataResult<Role>(this.roleDao.findById(id).get(), "Role data listed.");
    }
}
