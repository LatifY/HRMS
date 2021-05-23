package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelDao extends JpaRepository<Personel, Integer> {
}
