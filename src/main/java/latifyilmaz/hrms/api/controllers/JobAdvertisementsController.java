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

    //Put
    @PutMapping("/updateActive")
    public Result updateActive(@RequestParam(value = "active") boolean active, @RequestParam(value = "id") int id){
        return this.jobAdvertisementService.updateActive(active,id);
    }

    @PutMapping("/updateConfirmed")
    public Result updateConfirmed(@RequestParam(value = "confirmed") boolean confirmed, @RequestParam(value = "id") int id){
        return this.jobAdvertisementService.updateConfirmed(confirmed,id);
    }

    //Get
    @GetMapping("")
    public DataResult<List<JobAdvertisement>> getAll()  {
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/getAllByPage")
    public DataResult<List<JobAdvertisement>> getAll(@RequestParam(value = "pageNo") int pageNo, @RequestParam(value = "pageSize") int pageSize)  {
        return this.jobAdvertisementService.getAll(pageNo, pageSize);
    }

    @GetMapping("/{id}")
    public DataResult<JobAdvertisement> getById(@PathVariable(value = "id") int id){
        return this.jobAdvertisementService.getById(id);
    }

    @GetMapping("/getByActiveTrue")
    public DataResult<List<JobAdvertisement>> getByActiveTrue(){
        return this.jobAdvertisementService.getByActiveTrue();
    }

    @GetMapping("/getByConfirmedTrue")
    public DataResult<List<JobAdvertisement>> getByConfirmedTrue(){
        return this.jobAdvertisementService.getByConfirmedTrue();
    }

    @GetMapping("/getByActiveTrueAndConfirmedTrue")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrue(){
        return this.jobAdvertisementService.getByActiveTrueAndConfirmedTrue();
    }

    @GetMapping("/getByActiveTrueOrderByReleaseDate")
    public DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate(){
        return this.jobAdvertisementService.getByActiveTrueOrderByReleaseDate();
    }

    @GetMapping("/getByActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(@RequestParam(value = "employerId") int employerId){
        return this.jobAdvertisementService.getByActiveTrueAndEmployerId(employerId);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.jobAdvertisementService.deleteById(id);
    }

}
