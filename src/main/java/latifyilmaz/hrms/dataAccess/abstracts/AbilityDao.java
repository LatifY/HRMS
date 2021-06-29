package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
    List<Ability> getAllByResume_Id(int resumeId);

    @Modifying
    @Query("update Ability a set a.abilityName = ?2 where a.id = ?1")
    void updateById(int id, String abilityName);
}
