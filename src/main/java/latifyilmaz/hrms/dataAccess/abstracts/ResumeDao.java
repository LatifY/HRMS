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
    @Query("update Resume r set r.description=:resume.description, r.githubUrl:resume.githubUrl, r.linkedinUrl:resume.linkedinUrl where r.id=:resume.id")
    void updateById(ResumeUpdateDto resume);
}
