package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.dtos.employer.EmployerUpdateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getByUser_Email(String email);

    @Transactional
    @Modifying
    @Query("update Employer e set e.companyName=(:#{#dto.companyName}), e.website=(:#{#dto.website}), e.phone=(:#{#dto.phone}) where e.userId=(:#{#dto.userId})")
    void updateById(EmployerUpdateDto dto);
}
