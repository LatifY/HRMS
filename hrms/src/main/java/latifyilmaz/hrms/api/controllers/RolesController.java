package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.RoleService;
import latifyilmaz.hrms.entities.concretes.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getall")
    public List<Role> getAll(){
        return this.roleService.getAll();
    }
}
