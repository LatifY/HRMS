package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    Employee getByUser_Email(String email);
    Employee getByIdentityNo(String identityNo);

    @Transactional
    @Modifying
    @Query("update Employee e set e.firstName=:firstName, e.lastName=:lastName, e.birthYear=:birthYear, e.position=:position where e.userId=:userId")
    void updateById(int userId, String firstName, String lastName, int birthYear, Position position);

}
