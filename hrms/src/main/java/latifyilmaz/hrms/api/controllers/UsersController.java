package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<User> getById(@PathVariable(value = "id") int id){
        return this.userService.getById(id);
    }
}

