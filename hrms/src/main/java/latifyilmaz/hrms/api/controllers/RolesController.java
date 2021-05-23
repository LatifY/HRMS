package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.RoleService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    private RoleService roleService;

    @Autowired
    public RolesController(RoleService roleService){
        this.roleService = roleService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Role>> getAll(){
        return this.roleService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Role> getById(@PathVariable(value = "id") int id){
        return this.roleService.getById(id);
    }
}
