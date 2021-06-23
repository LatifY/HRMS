package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.CityService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.City;

import latifyilmaz.hrms.entities.dtos.city.CitySaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
    private final CityService cityService;

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

    //Post
    @PostMapping("")
    public Result save(@Valid @RequestBody CitySaveDto city){
        return this.cityService.save(city);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody City city){
        return this.cityService.delete(city);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.cityService.deleteById(id);
    }
}
