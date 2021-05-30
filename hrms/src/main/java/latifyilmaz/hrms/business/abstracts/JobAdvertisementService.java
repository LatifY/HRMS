package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementService {
    //Post
    Result save(JobAdvertisementSaveDto jobAdvertisement);

    //Put
    Result updateActive(boolean active, int id);

    //Get
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByActiveTrue();
    DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate();
    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId);
    DataResult<JobAdvertisement> getById(int id);
}
