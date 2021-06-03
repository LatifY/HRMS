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

    @GetMapping("/{id}")
    public DataResult<Language> getById(@PathVariable(value = "id") int id) {
        return this.languageService.getById(id);
    }

    @PostMapping("")
    public Result save(@RequestBody LanguageSaveDto language){
        return this.languageService.save(language);
    }
}