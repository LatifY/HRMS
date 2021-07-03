package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.JobAdvertisementService;
import latifyilmaz.hrms.core.utilities.results.DataResult;

import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementFilterDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementUpdateDto;
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
    @PutMapping("")
    public Result updateById(@RequestBody JobAdvertisementUpdateDto jobAdvertisement){
        return this.jobAdvertisementService.updateById(jobAdvertisement);
    }

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

    @GetMapping("/getAllByEmployerId")
    public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId)  {
        return this.jobAdvertisementService.getAllByEmployerId(employerId);
    }

    @GetMapping("/getAllByEmployerIdOrderByReleaseDateAsc")
    public DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateAsc(int employerId)  {
        return this.jobAdvertisementService.getAllByEmployerIdOrderByReleaseDateAsc(employerId);
    }

    @GetMapping("/getAllByEmployerIdOrderByReleaseDateDesc")
    public DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateDesc(int employerId)  {
        return this.jobAdvertisementService.getAllByEmployerIdOrderByReleaseDateDesc(employerId);
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

    @GetMapping("/getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc(){
        return this.jobAdvertisementService.getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc();
    }

    @GetMapping("/getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc(){
        return this.jobAdvertisementService.getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc();
    }


    @GetMapping("/getByActiveTrueAndEmployerIdOrderByReleaseDate")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerIdOrderByReleaseDate(int employerId){
        return this.jobAdvertisementService.getByActiveTrueAndEmployerIdOrderByReleaseDate(employerId);
    }

    @GetMapping("/getByActiveTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(@RequestParam(value = "employerId") int employerId){
        return this.jobAdvertisementService.getByActiveTrueAndEmployerId(employerId);
    }

    @PostMapping("/getByFilter")
    public DataResult<List<JobAdvertisement>> getByFilter(@RequestBody JobAdvertisementFilterDto filter, int pageNo, int pageSize){
        return this.jobAdvertisementService.getByFilter(filter, pageNo, pageSize);
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
