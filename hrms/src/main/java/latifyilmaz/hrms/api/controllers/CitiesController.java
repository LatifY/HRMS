package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.CityService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService){
        super();
        this.cityService = cityService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<City>> getAll()  {
        return this.cityService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<City> getById(@PathVariable(value = "id") int id){
        return this.cityService.getById(id);
    }

}
