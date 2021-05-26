package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    DataResult<Employee> findByEmail(String email);
    DataResult<Employee> findByTcNo(String tcNo);
}
