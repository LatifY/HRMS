package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.*;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.JobAdvertisementDao;
import latifyilmaz.hrms.entities.concretes.JobAdvertisement;
import latifyilmaz.hrms.entities.dtos.jobAdvertisement.JobAdvertisementSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
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


    private final String FIELD = "jobAdvertisement";

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, PositionService positionService, CityService cityService, WorkingTimeService workingTimeService, EmployerService employerService){
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.positionService = positionService;
        this.cityService = cityService;
        this.workingTimeService = workingTimeService;
        this.employerService = employerService;
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


    //Get
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(pageable).getContent(), MessageResults.allDataListed(FIELD));
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
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueOrderByReleaseDate(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<JobAdvertisement>> getByActiveTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByActiveTrueAndEmployer_UserId(employerId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<JobAdvertisement> getById(int id) {
        return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.delete(jobAdvertisement);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.jobAdvertisementDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
