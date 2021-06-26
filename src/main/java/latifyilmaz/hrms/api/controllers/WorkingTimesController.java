package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.WorkingTimeService;
import latifyilmaz.hrms.core.utilities.results.DataResult;

import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.WorkingTime;
import latifyilmaz.hrms.entities.dtos.workingTime.WorkingTimeSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {
    private WorkingTimeService workingTimeService;

    @Autowired
    public WorkingTimesController(WorkingTimeService workingTimeService){
        super();
        this.workingTimeService = workingTimeService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<WorkingTime>> getAll()  {
        return this.workingTimeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<WorkingTime> getById(@PathVariable(value = "id") int id){
        return this.workingTimeService.getById(id);
    }

    @GetMapping("/getByWorkingTimeName")
    public DataResult<WorkingTime> getByWorkingTimeName(@PathVariable(value = "workingTimeName") String workingTimeName){
        return this.workingTimeService.getByWorkingTimeName(workingTimeName);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody WorkingTimeSaveDto workingTime){
        return this.workingTimeService.save(workingTime);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody WorkingTime workingTime){
        return this.workingTimeService.delete(workingTime);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.workingTimeService.deleteById(id);
    }

}
