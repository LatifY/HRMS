package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.WorkingTimeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessResult;
import latifyilmaz.hrms.dataAccess.abstracts.WorkingTimeDao;
import latifyilmaz.hrms.entities.concretes.WorkingTime;
import latifyilmaz.hrms.entities.dtos.workingTime.WorkingTimeSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTimeManager implements WorkingTimeService {

    private final WorkingTimeDao workingTimeDao;
    private final String FIELD = "workingTime";
    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao){
        this.workingTimeDao = workingTimeDao;
    }
    public DataResult<List<WorkingTime>> getAll() {
        return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<WorkingTime> getById(int id) {
        return new SuccessDataResult<WorkingTime>(workingTimeDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result save(WorkingTimeSaveDto workingTime) {
        WorkingTime workingTimeObject = new WorkingTime(workingTime.getWorkingTimeName());

        this.workingTimeDao.save(workingTimeObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result delete(WorkingTime workingTime) {
        this.workingTimeDao.delete(workingTime);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.workingTimeDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
