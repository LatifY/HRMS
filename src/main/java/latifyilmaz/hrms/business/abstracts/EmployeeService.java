package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeSaveDto;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {
    //Get
    DataResult<List<Employee>> getAll();
    DataResult<Employee> getById(int id);
    DataResult<Employee> getByEmail(String email);
    DataResult<Employee> getByIdentityNo(String tcNo);

    //Post
    Result save(EmployeeSaveDto employee);

    //Put
    Result updateById(EmployeeUpdateDto employee);

    //Delete
    Result delete(Employee employee);
    Result deleteById(int id);
}
