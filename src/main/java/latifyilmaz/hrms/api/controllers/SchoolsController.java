package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.SchoolService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.School;
import latifyilmaz.hrms.entities.dtos.school.SchoolSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<School>> getAll() {
        return this.schoolService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<School> getById(@PathVariable(value = "id") int id) {
        return this.schoolService.getById(id);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody SchoolSaveDto school){
        return this.schoolService.save(school);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody School school){
        return this.schoolService.delete(school);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.schoolService.deleteById(id);
    }
}
