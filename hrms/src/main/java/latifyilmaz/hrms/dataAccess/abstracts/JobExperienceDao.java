package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
}
