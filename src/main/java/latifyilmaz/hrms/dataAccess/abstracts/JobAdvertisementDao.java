package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
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
}
