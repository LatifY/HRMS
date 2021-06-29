package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.resume.ResumeUpdateDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
    Resume getByEmployee_UserId(int employeeId);

    @Transactional
    @Modifying
    @Query("update Resume r set r.description=:description, r.githubUrl:githubUrl, r.linkedinUrl:linkedinUrl where r.id=:id")
    void updateById(int id, String description, String githubUrl, String linkedinUrl);
}
