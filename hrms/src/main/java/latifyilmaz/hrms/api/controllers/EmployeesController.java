package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController implements EmployeeService {
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

    //Post
    public Result save(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName,
                       @PathVariable(value = "tcNo") String tcNo, @PathVariable(value = "dateOfBirthYear") int dateOfBirthYear,
                       @PathVariable(value = "email") String email, @PathVariable(value = "password") String password, @PathVariable(value = "passwordRetry") String passwordRetry) {
        return this.employeeService.save(firstName, lastName, tcNo, dateOfBirthYear, email, password, passwordRetry);
    }
}
