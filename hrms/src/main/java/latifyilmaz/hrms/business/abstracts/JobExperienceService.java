package latifyilmaz.hrms.business.abstracts;


import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobExperience;
import latifyilmaz.hrms.entities.dtos.jobExperience.JobExperienceSaveDto;

import java.util.List;

public interface JobExperienceService {
    DataResult<List<JobExperience>> getAll();
    DataResult<JobExperience> getById(int id);
    DataResult<List<JobExperience>> getByIds(List<Integer> ids);


    Result save(JobExperienceSaveDto jobExperience);
}
