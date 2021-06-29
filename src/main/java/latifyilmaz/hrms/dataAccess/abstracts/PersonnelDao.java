package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PersonnelDao extends JpaRepository<Personnel, Integer> {
    Personnel getByUser_Email(String email);

    @Transactional
    @Modifying
    @Query("update Personnel p set p.firstName=:firstName, p.lastName=:lastName where p.userId=:userId")
    void updateById(int userId, String firstName, String lastName);
}
