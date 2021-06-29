package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
    List<Ability> getAllByResume_Id(int resumeId);

    @Transactional
    @Modifying
    @Query("update Ability a set a.abilityName=:abilityName where a.id=:id")
    void updateById(int id, String abilityName);
}
