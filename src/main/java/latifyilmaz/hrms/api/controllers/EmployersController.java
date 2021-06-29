package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployerService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.ErrorDataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;
import latifyilmaz.hrms.entities.dtos.employer.EmployerUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService = employerService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(this.employerService.getById(id));
    }

    @GetMapping("/getByEmail")
    public DataResult<Employer> getByEmail(@RequestParam(value = "email") String email) {
        return this.employerService.getByEmail(email);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody EmployerSaveDto employer) {
        return this.employerService.save(employer);
    }

    //Put
    @PutMapping("")
    public Result updateById(@RequestBody EmployerUpdateDto employer){
        return this.employerService.updateById(employer);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Employer employer){
        return this.employerService.delete(employer);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.employerService.deleteById(id);
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
