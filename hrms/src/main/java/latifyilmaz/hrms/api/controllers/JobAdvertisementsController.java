package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.JobAdvertisementService;
import latifyilmaz.hrms.core.utilities.results.DataResult;

import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
@CrossOrigin
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService cityService){
        super();
        this.jobAdvertisementService = cityService;
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody JobAdvertisementSaveDto jobAdvertisement){
        return this.jobAdvertisementService.save(jobAdvertisement);
    }

    //Post
    @PutMapping("/changeActive")
    public Result changeActive(@RequestParam(value = "active") boolean active, @RequestParam(value = "id") int id){
        return this.jobAdvertisementService.updateActive(active,id);
    }

    //Get
    @GetMapping("")
    public DataResult<List<JobAdvertisement>> getAll()  {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<JobAdvertisement> getById(@PathVariable(value = "id") int id){
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/getByActiveTrue")
    public DataResult<List<JobAdvertisement>> getByActiveTrue(){
        return this.jobAdvertisementService.getByActiveTrue();
    }

    @GetMapping("/getByActiveTrueOrderByReleaseDate")
    public DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate(){
        return this.jobAdvertisementService.getByActiveTrueOrderByReleaseDate();
    }

    @GetMapping("/getByActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(@RequestParam(value = "employerId") int employerId){
        return this.jobAdvertisementService.getByActiveTrueAndEmployerId(employerId);
    }

}
