package latifyilmaz.hrms.business.abstracts;


import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.JobExperience;
import latifyilmaz.hrms.entities.dtos.jobExperience.JobExperienceSaveDto;

import java.util.List;

public interface JobExperienceService {
    //Get
    DataResult<List<JobExperience>> getAll();
    DataResult<List<JobExperience>> getAllByResumeId(int resumeId);
    DataResult<JobExperience> getById(int id);
    DataResult<List<JobExperience>> getByIds(List<Integer> ids);

    //Post
    Result save(JobExperienceSaveDto jobExperience);

    //Delete
    Result delete(JobExperience jobExperience);
    Result deleteById(int id);
    Result deleteByIds(List<Integer> ids);
    Result deleteAll(List<JobExperience> jobExperiences);
}
