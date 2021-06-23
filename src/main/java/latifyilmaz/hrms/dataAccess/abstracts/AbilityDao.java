package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
}
