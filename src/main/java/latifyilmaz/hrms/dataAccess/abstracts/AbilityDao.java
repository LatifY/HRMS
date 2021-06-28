package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
    List<Ability> getAllByResume_Id(int resumeId);
}
