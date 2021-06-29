package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.ErrorDataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeSaveDto;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeUpdateDto;
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
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Employee>> getAll() {
        return this.employeeService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(this.employeeService.getById(id));
    }

    @GetMapping("/getByEmail")
    public DataResult<Employee> getByEmail(@RequestParam(value = "email") String email) {
        return this.employeeService.getByEmail(email);
    }

    @GetMapping("/getByIdentityNo")
    public DataResult<Employee> getByIdentityNo(@RequestParam(value = "identityNo") String identityNo) {
        return this.employeeService.getByIdentityNo(identityNo);
    }

    //Post
    @PostMapping("")
    public Result save(@RequestBody EmployeeSaveDto employee) {
        return this.employeeService.save(employee);
    }

    //Put
    @PutMapping("")
    public Result save(@RequestBody EmployeeUpdateDto employee) {
        return this.employeeService.updateById(employee);
    }

    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Employee employee){
        return this.employeeService.delete(employee);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "") int id){
        return this.employeeService.deleteById(id);
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
