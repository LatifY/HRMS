package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService = employerService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Employer> getById(@PathVariable(value = "id") int id){
        return this.employerService.getById(id);
    }

    @GetMapping("/getByEmail")
    public DataResult<Employer> getByEmail(@RequestParam(value = "email") String email) {
        return this.employerService.getByEmail(email);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody EmployerSaveDto employer) {
        return this.employerService.save(employer);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Employer employer){
        return this.employerService.delete(employer);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.employerService.deleteById(id);
    }
}
