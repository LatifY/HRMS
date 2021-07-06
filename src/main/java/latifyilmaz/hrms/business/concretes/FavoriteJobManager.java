package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.FavoriteJobService;
import latifyilmaz.hrms.business.abstracts.JobAdvertisementService;
import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessResult;
import latifyilmaz.hrms.dataAccess.abstracts.FavoriteJobDao;
import latifyilmaz.hrms.entities.concretes.FavoriteJob;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.favoriteJob.FavoriteJobSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteJobManager implements FavoriteJobService {
    private final FavoriteJobDao favoriteJobDao;
    private final UserService userService;
    private final JobAdvertisementService jobAdvertisementService;

    private final String FIELD = "favoriteJob";

    @Autowired
    public FavoriteJobManager(FavoriteJobDao favoriteJobDao, UserService userService, JobAdvertisementService jobAdvertisementService){
        this.favoriteJobDao = favoriteJobDao;
        this.userService = userService;
        this.jobAdvertisementService = jobAdvertisementService;
    }

    public DataResult<List<FavoriteJob>> getAll() {
        return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<FavoriteJob> getById(int id) {
        return new SuccessDataResult<FavoriteJob>(this.favoriteJobDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<FavoriteJob>> getByJobAdvertisementId(int id) {
        return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.getByJobAdvertisement_Id(id), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<FavoriteJob>> getByUserId(int id) {
        return new SuccessDataResult<List<FavoriteJob>>(this.favoriteJobDao.getByUser_Id(id), MessageResults.allDataListed(FIELD));
    }

    public Result save(FavoriteJobSaveDto dto) {
        User user = userService.getById(dto.getUserId()).getData();
        JobAdvertisement jobAdvertisement = jobAdvertisementService.getById(dto.getUserId()).getData();
        FavoriteJob favoriteJob = new FavoriteJob(user, jobAdvertisement);
        return new SuccessResult(MessageResults.jobAddedFavorite);
    }

    public Result delete(FavoriteJob favoriteJob) {
        this.favoriteJobDao.delete(favoriteJob);
        return new SuccessResult(MessageResults.jobRemovedFavorite);
    }

    public Result deleteById(int id) {
        this.favoriteJobDao.deleteById(id);
        return new SuccessResult(MessageResults.jobRemovedFavorite);
    }
}
