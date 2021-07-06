package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Ability;
import latifyilmaz.hrms.entities.concretes.FavoriteJob;
import latifyilmaz.hrms.entities.dtos.ability.AbilitySaveDto;
import latifyilmaz.hrms.entities.dtos.ability.AbilityUpdateDto;
import latifyilmaz.hrms.entities.dtos.favoriteJob.FavoriteJobSaveDto;

import java.util.List;

public interface FavoriteJobService {
    //Get
    DataResult<List<FavoriteJob>> getAll();
    DataResult<FavoriteJob> getById(int id);

    DataResult<List<FavoriteJob>> getByJobAdvertisementId(int id);
    DataResult<List<FavoriteJob>> getByUserId(int id);
    DataResult<List<FavoriteJob>> getByUserEmail(String email);

    //Post
    Result save(FavoriteJobSaveDto dto);

    //Delete
    Result delete(FavoriteJob favoriteJob);
    Result deleteAll(List<FavoriteJob> favoriteJobs);
    Result deleteById(int id);
}
