package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.City;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.concretes.WorkingTime;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementFilterDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getAllByOrderByReleaseDateDesc();
    List<JobAdvertisement> getAllByEmployer_UserId(int employerId);
    List<JobAdvertisement> getAllByEmployer_UserIdOrderByReleaseDateAsc(int employerId);
    List<JobAdvertisement> getAllByEmployer_UserIdOrderByReleaseDateDesc(int employerId);

    List<JobAdvertisement> getByActiveTrue();
    List<JobAdvertisement> getByConfirmedTrue();
    List<JobAdvertisement> getByActiveTrueAndConfirmedTrue();
    List<JobAdvertisement> getByActiveTrueOrderByReleaseDateDesc();
    List<JobAdvertisement> getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc();
    List<JobAdvertisement> getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc();


    List<JobAdvertisement> getByActiveTrueAndEmployer_UserId(int employerId);
    List<JobAdvertisement> getByActiveTrueAndEmployer_UserIdOrderByReleaseDateDesc(int employerId);

    @Query("Select j from latifyilmaz.hrms.entities.concretes.JobAdvertisement j where " +
            "((:#{#filter.cityIds}) IS NULL OR j.city.id IN (:#{#filter.cityIds})) and " +
            "((:#{#filter.positionIds}) IS NULL OR j.position.id IN (:#{#filter.positionIds})) and " +
            "((:#{#filter.workingTimeIds}) IS NULL OR j.workingTime.id IN (:#{#filter.workingTimeIds})) and " +
            "j.active=true and j.confirmed=true and " +
            "((:#{#filter.search}) IS NULL OR j.description like %:#{#filter.search}% OR LOWER(j.description) like %:#{#filter.search}% OR UPPER(j.description) like %:#{#filter.search}%) and " +
            "((:#{#filter.minSalary}) IS NULL OR (:#{#filter.minSalary}) = 0 OR j.minSalary >= (:#{#filter.minSalary})) and " +
            "((:#{#filter.maxSalary}) IS NULL OR (:#{#filter.maxSalary}) = 0 OR j.maxSalary <= (:#{#filter.maxSalary}))" +
            " ORDER BY j.releaseDate DESC")
    public Page<JobAdvertisement> getByFilter(@Param("filter") JobAdvertisementFilterDto filter, Pageable pageable);

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
    @Query("update JobAdvertisement j set j.active=(:#{#job.active}), j.description=(:#{#job.description}), j.city.id=(:#{#job.cityId}), " +
            "j.workingTime.id=(:#{#job.workingTimeId}), j.position.id=(:#{#job.positionId}), j.deadline=(:#{#job.deadline}), " +
            "j.minSalary=(:#{#job.minSalary}), j.maxSalary=(:#{#job.maxSalary}), j.openPositionsAmount=(:#{#job.openPositionsAmount}) " +
            "where j.id=(:#{#job.id})")
    void updateById(JobAdvertisementUpdateDto job);
}
