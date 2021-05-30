package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personnels")
public class PersonnelsController {
    private PersonnelService personnelService;

    @Autowired
    public PersonnelsController(PersonnelService personnelService){
        this.personnelService = personnelService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Personnel>> getAll(){
        return this.personnelService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Personnel> getById(@PathVariable(value = "id") int id){
        return this.personnelService.getById(id);
    }
}
