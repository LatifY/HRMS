package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.JobExperienceService;
import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.JobExperienceDao;
import latifyilmaz.hrms.entities.concretes.JobExperience;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.jobExperience.JobExperienceSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private final JobExperienceDao jobExperienceDao;
    private final ResumeService resumeService;
    private final String FIELD = "jobExperience";

    @Autowired
    private JobExperienceManager(JobExperienceDao jobExperienceDao, ResumeService resumeService){
        this.jobExperienceDao = jobExperienceDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<JobExperience> getById(int id) {
        return new SuccessDataResult<JobExperience>(this.jobExperienceDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<JobExperience>> getByIds(List<Integer> ids) {
        List<JobExperience> jobExperiences = new ArrayList<>();

        for(var id : ids){
            DataResult<JobExperience> jobExperienceDataResult = getById(id);
            if(jobExperienceDataResult.isSuccess()){
                jobExperiences.add(jobExperienceDataResult.getData());
            }
        }

        return new SuccessDataResult<List<JobExperience>>(jobExperiences, MessageResults.allDataListed(FIELD));
    }

    public Result save(JobExperienceSaveDto jobExperience) {
        if(StringTools.isStringNullOrEmpty(jobExperience.getCompanyName()) ||
                StringTools.isStringNullOrEmpty(jobExperience.getPositionName()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(jobExperience.getStartYear()))){
            return new ErrorResult(MessageResults.emptyField);
        }
        Resume resume = resumeService.getById(jobExperience.getResumeId()).getData();

        JobExperience jobExperienceObject = new JobExperience(
                resume,
                jobExperience.getCompanyName(),
                jobExperience.getPositionName(),
                jobExperience.getStartYear(),
                jobExperience.getEndYear()
        );

        this.jobExperienceDao.save(jobExperienceObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }


}
