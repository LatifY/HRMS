package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.RoleService;
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
        this.roleDao = roleDao;
    }

    public List<Role> getAll() {
        return roleDao.findAll();
    }
}
