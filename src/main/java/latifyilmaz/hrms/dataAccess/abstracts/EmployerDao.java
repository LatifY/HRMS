package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    Employer getByUser_Email(String email);

    @Transactional
    @Modifying
    @Query("update Employer e set e.companyName=:companyName, e.website=:website, e.phone=:phone where e.userId=:userId")
    void updateById(int userId, String companyName, String website, String phone);
}
