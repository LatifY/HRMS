package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PersonelService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personels")
public class PersonelsController {
    private PersonelService personelService;

    @Autowired
    public PersonelsController(PersonelService personelService){
        this.personelService = personelService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Personel>> getAll(){
        return this.personelService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Personel> getById(@PathVariable(value = "id") int id){
        return this.personelService.getById(id);
    }
}
