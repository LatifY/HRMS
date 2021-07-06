package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.entities.concretes.FavoriteJob;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteJobDao extends JpaRepository<FavoriteJob, Integer> {
    List<FavoriteJob> getByUser_Id(int id);
    List<FavoriteJob> getByJobAdvertisement_Id(int id);
}
