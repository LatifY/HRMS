package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementFilterDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementUpdateDto;

import java.util.Date;
import java.util.List;

public interface JobAdvertisementService {
    //Post
    Result save(JobAdvertisementSaveDto jobAdvertisement);

    //Put
    Result updateActive(boolean active, int id);
    Result updateConfirmed(boolean confirmed, int id);
    Result updateById(JobAdvertisementUpdateDto jobAdvertisement);

    //Get
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize);
    DataResult<List<JobAdvertisement>> getAllOrderByReleaseDateDesc();
    DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId);
    DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateAsc(int employerId);
    DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateDesc(int employerId);

    DataResult<List<JobAdvertisement>> getByActiveTrue();
    DataResult<List<JobAdvertisement>> getByConfirmedTrue();
    DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrue();
    DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate();
    DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc();
    DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc();

    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerIdOrderByReleaseDate(int employerId);
    DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId);

    DataResult<List<JobAdvertisement>> getByFilter(JobAdvertisementFilterDto filter, int pageNo, int pageSize);
    DataResult<JobAdvertisement> getById(int id);

    //Delete
    Result delete(JobAdvertisement jobAdvertisement);
    Result deleteById(int id);
}
