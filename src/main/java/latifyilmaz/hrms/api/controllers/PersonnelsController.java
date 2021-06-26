package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.ErrorDataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Personnel;
import latifyilmaz.hrms.entities.dtos.personnel.PersonnelSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/personnels")
@CrossOrigin
public class PersonnelsController {
    private PersonnelService personnelService;

    @Autowired
    public PersonnelsController(PersonnelService personnelService){
        this.personnelService = personnelService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Personnel>> getAll(){
        return this.personnelService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(this.personnelService.getById(id));
    }

    @GetMapping("/getByEmail")
    public DataResult<Personnel> getByEmail(@PathVariable(value = "email") String email){
        return this.personnelService.getByEmail(email);
    }

    //Post
    @PostMapping("")
    public Result save(@Valid @RequestBody PersonnelSaveDto personnel){
        return this.personnelService.save(personnel);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Personnel personnel){
        return this.personnelService.delete(personnel);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.personnelService.deleteById(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, MessageResults.error);
        return errors;
    }
}
