package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.resume.ResumeSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/resumes")
public class ResumeesController {
    private ResumeService resumeService;

    @Autowired
    public ResumeesController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Resume> getById(@PathVariable(value = "id") int id) {
        return this.resumeService.getById(id);
    }

    @PostMapping("")
    public Result save(@Valid @RequestBody ResumeSaveDto resume){
        return this.resumeService.save(resume);
    }
}
