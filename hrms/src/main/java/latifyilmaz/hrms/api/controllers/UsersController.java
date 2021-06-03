package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController{
    private UserService userService;

    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<User> getById(@PathVariable(value = "id") int id) {
        return this.userService.getById(id);
    }

    @GetMapping("/getByEmail")
    public DataResult<User> getByEmail(@RequestParam(value = "email") String email) {
        return this.userService.getByEmail(email);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody User user) {
        return this.userService.save(user);
    }

    public Result verifyById(int id) {
        return this.userService.verifyById(id);
    }

    public Result verifyByEmail(String email) {
        return this.userService.verifyByEmail(email);
    }
}
