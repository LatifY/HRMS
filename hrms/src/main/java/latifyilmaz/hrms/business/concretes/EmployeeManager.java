package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.EmployeeService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.EmployeeDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao){
        super();
        this.employeeDao = employeeDao;
    }

    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "All Employee data listed.");
    }

    public DataResult<Employee> getById(int id) {
        return new SuccessDataResult<Employee>(this.employeeDao.findById(id).get(), "Employee data listed.");
    }
}
