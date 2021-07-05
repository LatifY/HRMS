package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.dtos.employee.EmployeeUpdateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    Employee getByUser_Email(String email);
    Employee getByIdentityNo(String identityNo);

    @Transactional
    @Modifying
    @Query("update Employee e set e.firstName=(:#{#dto.firstName}), e.lastName=(:#{#dto.lastName}), " +
            "e.birthYear=(:#{#dto.birthYear}), e.position.id=(:#{#dto.positionId}) where e.userId=(:#{#dto.userId})")
    void updateById(EmployeeUpdateDto dto);
}
