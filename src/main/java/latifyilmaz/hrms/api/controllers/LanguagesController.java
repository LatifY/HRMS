package latifyilmaz.hrms.api.controllers;


import latifyilmaz.hrms.business.abstracts.LanguageService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Language;
import latifyilmaz.hrms.entities.dtos.language.LanguageSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }

    @GetMapping("/getAllByResumeId")
    public DataResult<List<Language>> getAllByResumeId(int resumeId) {
        return this.languageService.getAllByResumeId(resumeId);
    }

    @GetMapping("/{id}")
    public DataResult<Language> getById(@PathVariable(value = "id") int id) {
        return this.languageService.getById(id);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody LanguageSaveDto language){
        return this.languageService.save(language);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Language language){
        return this.languageService.delete(language);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.languageService.deleteById(id);
    }
}