package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Personnel;
import latifyilmaz.hrms.entities.dtos.personnel.PersonnelSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/personnels")
@CrossOrigin
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


    @PostMapping("")
    public Result save(@Valid @RequestBody PersonnelSaveDto personnel){
        return this.personnelService.save(personnel);
    }
}
