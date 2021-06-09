package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeesController {
    private EmployeeService employeeService;

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
    public DataResult<Employee> getById(@PathVariable(value = "id") int id) {
        return this.employeeService.getById(id);
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
}
