package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.City;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getAllByEmployer_UserId(int employerId);
    List<JobAdvertisement> getByActiveTrue();
    List<JobAdvertisement> getByConfirmedTrue();
    List<JobAdvertisement> getByActiveTrueAndConfirmedTrue();
    List<JobAdvertisement> getByActiveTrueOrderByReleaseDate();
    List<JobAdvertisement> getByActiveTrueAndEmployer_UserId(int employerId);

    @Transactional
    @Modifying
    @Query("update JobAdvertisement j set j.active=:active where j.id=:id")
    void updateActive(boolean active, int id);

    @Transactional
    @Modifying
    @Query("update JobAdvertisement j set j.confirmed=:confirmed where j.id=:id")
    void updateConfirmed(boolean confirmed, int id);

    @Transactional
    @Modifying
    @Query("update JobAdvertisement j set j.description=:description, j.city=:city, " +
            "j.workingTime=:workingTime, j.position=:position, j.deadline=:deadline, " +
            "j.minSalary=:minSalary, j.maxSalary=:maxSalary, j.openPositionsAmount=:openPositionsAmount " +
            "where j.id=:id")
    void updateById(int id, String description, City city, WorkingTime workingTime, Position position, Date deadline, int minSalary, int maxSalary, int openPositionsAmount);
}
