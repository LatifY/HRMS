package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.*;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.JobAdvertisementDao;
import latifyilmaz.hrms.entities.concretes.*;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementFilterDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private final JobAdvertisementDao jobAdvertisementDao;
    private final PositionService positionService;
    private final CityService cityService;
    private final WorkingTimeService workingTimeService;
    private final EmployerService employerService;
    private final FavoriteJobService favoriteJobService;


    private final String FIELD = "jobAdvertisement";

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, PositionService positionService, CityService cityService, WorkingTimeService workingTimeService, @Lazy EmployerService employerService, @Lazy FavoriteJobService favoriteJobService){
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.positionService = positionService;
        this.cityService = cityService;
        this.workingTimeService = workingTimeService;
        this.employerService = employerService;
        this.favoriteJobService = favoriteJobService;
    }

    //Post
    public Result save(JobAdvertisementSaveDto jobAdvertisement) {
        if (StringTools.isStringNullOrEmpty(jobAdvertisement.getDescription()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getOpenPositionsAmount())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getCityId())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getPositionId())) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobAdvertisement.getDeadline()))) {
            return new ErrorResult(MessageResults.emptyFields);
        }

        JobAdvertisement jobAdvertisementObject= new JobAdvertisement(
                jobAdvertisement.getDescription(),
                new Date(System.currentTimeMillis()),
                jobAdvertisement.getDeadline(),
                jobAdvertisement.getMinSalary(),
                jobAdvertisement.getMaxSalary(),
                jobAdvertisement.getOpenPositionsAmount(),
                true,
                false
        );

        jobAdvertisementObject.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
        jobAdvertisementObject.setWorkingTime(workingTimeService.getById(jobAdvertisement.getWorkingTimeId()).getData());
        jobAdvertisementObject.setPosition(positionService.getById(jobAdvertisement.getPositionId()).getData());
        jobAdvertisementObject.setEmployer(employerService.getById(jobAdvertisement.getEmployerId()).getData());

        this.jobAdvertisementDao.save(jobAdvertisementObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }


    //Put
    public Result updateActive(boolean active, int id) {
        this.jobAdvertisementDao.updateActive(active, id);
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result updateConfirmed(boolean confirmed, int id) {
        this.jobAdvertisementDao.updateConfirmed(confirmed, id);
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result updateById(JobAdvertisementUpdateDto jobAdvertisement) {
        //City city = cityService.getById(jobAdvertisement.getCityId()).getData();
        //WorkingTime workingTime = workingTimeService.getById(jobAdvertisement.getWorkingTimeId()).getData();
        //Position position = positionService.getById(jobAdvertisement.getPositionId()).getData();

        this.jobAdvertisementDao.updateById(jobAdvertisement);
        return new SuccessResult(MessageResults.updated(FIELD));
    }


    //Get
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAllOrderByReleaseDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByOrderByReleaseDateDesc(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAllByEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployer_UserId(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateAsc(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployer_UserIdOrderByReleaseDateAsc(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAllByEmployerIdOrderByReleaseDateDesc(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getAllByEmployer_UserIdOrderByReleaseDateDesc(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrue(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByConfirmedTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByConfirmedTrue(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndConfirmedTrue(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueOrderByReleaseDate() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueOrderByReleaseDateDesc(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndConfirmedTrueOrderByReleaseDateAsc(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndConfirmedTrueOrderByReleaseDateDesc(), MessageResults.allDataListed(FIELD));
    }



    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerIdOrderByReleaseDate(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndEmployer_UserIdOrderByReleaseDateDesc(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndEmployer_UserId(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByFilter(JobAdvertisementFilterDto filter, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        var data = this.jobAdvertisementDao.getByFilter(filter, pageable);
        return new SuccessDataResult<List<JobAdvertisement>>(data.getContent(), String.valueOf(data.getTotalPages()));
    }


    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result delete(JobAdvertisement jobAdvertisement) {
        List<FavoriteJob> favoriteJobs = favoriteJobService.getByJobAdvertisementId(jobAdvertisement.getId()).getData();
        favoriteJobService.deleteAll(favoriteJobs);
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        List<FavoriteJob> favoriteJobs = favoriteJobService.getByJobAdvertisementId(id).getData();
        favoriteJobService.deleteAll(favoriteJobs);
        this.jobAdvertisementDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
