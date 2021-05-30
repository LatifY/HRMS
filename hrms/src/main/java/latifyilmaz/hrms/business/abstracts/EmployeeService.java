package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeSaveDto;

import java.util.List;

public interface EmployeeService {
    //Get (GET)
    DataResult<List<Employee>> getAll();
    DataResult<Employee> getById(int id);
    DataResult<Employee> getByEmail(String email);
    DataResult<Employee> getByIdentityNo(String tcNo);

    Result save(EmployeeSaveDto employee);
}
