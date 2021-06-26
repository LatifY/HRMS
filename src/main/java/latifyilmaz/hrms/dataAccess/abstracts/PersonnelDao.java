package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnelDao extends JpaRepository<Personnel, Integer> {
    Personnel getByUser_Email(String email);
}
