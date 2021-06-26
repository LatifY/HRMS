package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.WorkingTime;
import latifyilmaz.hrms.entities.dtos.workingTime.WorkingTimeSaveDto;

import java.util.List;

public interface WorkingTimeService {
    //Get
    DataResult<List<WorkingTime>> getAll();
    DataResult<WorkingTime> getById(int id);
    DataResult<WorkingTime> getByWorkingTimeName(String workingTimeName);

    //Save
    Result save(WorkingTimeSaveDto workingTime);

    //Delete
    Result delete(WorkingTime workingTime);
    Result deleteById(int id);
}
