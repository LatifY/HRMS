package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.concretes.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
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

    //Post
    public Result save(@PathVariable(value = "companyName") String companyName, @PathVariable(value = "website") String website,
                       @PathVariable(value = "phone") String phone, @PathVariable(value = "email") String email,
                       @PathVariable(value = "password") String password, @PathVariable(value = "passwordRetry") String passwordRetry) {
        return this.employerService.save(companyName, website, phone, email, password, passwordRetry);
    }
}
