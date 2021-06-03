package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.JobExperienceService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobExperience;
import latifyilmaz.hrms.entities.dtos.jobExperience.JobExperienceSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobExperiences")
public class JobExperiencesController {
    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService){
        this.jobExperienceService = jobExperienceService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<JobExperience> getById(@PathVariable(value = "id") int id) {
        return this.jobExperienceService.getById(id);
    }

    @PostMapping("")
    public Result save(@RequestBody JobExperienceSaveDto jobExperience){
        return this.jobExperienceService.save(jobExperience);
    }
}
