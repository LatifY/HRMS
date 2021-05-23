package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employee;

import java.util.List;

public interface EmployeeService {
    //Get (GET)
    DataResult<List<Employee>> getAll();
    DataResult<Employee> getById(int id);
}
