package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.user.UserLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController{
    private final UserService userService;

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

    @GetMapping("/getUserTypeByEmail")
    public DataResult<?> getUserTypeByEmail(String email){
        return this.userService.getUserTypeByEmail(email);
    }

    @GetMapping("/getByEmailAndPassword")
    public DataResult<User> getByEmailAndPassword(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
        return this.userService.getByEmailAndPassword(email, password);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PostMapping("/login")
    public DataResult<?> login(@RequestBody UserLoginDto user){
        return this.userService.login(user);
    }


    //Put
    @PutMapping("/verifyById")
    public Result verifyById(int id) {
        return this.userService.verifyById(id);
    }

    @PutMapping("/verifyByEmail")
    public Result verifyByEmail(String email) {
        return this.userService.verifyByEmail(email);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody User user){
        return this.userService.delete(user);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.userService.deleteById(id);
    }
}
