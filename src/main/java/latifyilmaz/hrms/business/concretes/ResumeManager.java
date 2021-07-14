package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.*;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.dataAccess.abstracts.ResumeDao;
import latifyilmaz.hrms.entities.concretes.*;
import latifyilmaz.hrms.entities.dtos.resume.ResumeSaveDto;
import latifyilmaz.hrms.entities.dtos.resume.ResumeUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {
    private final ResumeDao resumeDao;
    private final EmployeeService employeeService;

    private final AbilityService abilityService;
    private final ImageService imageService;
    private final SchoolService schoolService;
    private final JobExperienceService jobExperienceService;
    private final LanguageService languageService;

    private final String FIELD = "resume";

    @Autowired
    public ResumeManager(@Lazy ResumeDao resumeDao, @Lazy EmployeeService employeeService, @Lazy LanguageService languageService, @Lazy AbilityService abilityService, @Lazy SchoolService schoolService, @Lazy ImageService imageService, @Lazy JobExperienceService jobExperienceService) {
        this.resumeDao = resumeDao;
        this.employeeService = employeeService;
        this.languageService = languageService;
        this.abilityService = abilityService;
        this.schoolService = schoolService;
        this.imageService = imageService;
        this.jobExperienceService = jobExperienceService;
    }


    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>(this.resumeDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Resume> getByEmployeeId(int employeeId) {
        return new SuccessDataResult<Resume>(this.resumeDao.getByEmployee_UserId(employeeId), MessageResults.dataListed(FIELD));
    }

    public Result save(ResumeSaveDto resume) {
        DataResult<Employee> employee = employeeService.getById(resume.getEmployeeId());

        Resume resumeObject = new Resume(
                employee.getData(),
                resume.getGithubUrl(),
                resume.getLinkedinUrl(),
                resume.getDescription()
        );

        this.resumeDao.save(resumeObject);

        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result updateById(ResumeUpdateDto resume) {
        this.resumeDao.updateById(resume.getId(),resume.getDescription(),resume.getGithubUrl(),resume.getLinkedinUrl());
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result delete(Resume resume) {
        this.resumeDao.delete(resume);
        this.abilityService.deleteAll(resume.getAbilities());
        this.imageService.deleteAll(resume.getImages());
        this.schoolService.deleteAll(resume.getSchools());
        this.jobExperienceService.deleteAll(resume.getJobExperiences());
        this.languageService.deleteAll(resume.getLanguages());
        return new SuccessResult(MessageResults.deleted(FIELD));
    }


    public Result deleteById(int id) {
        DataResult<Resume> resume = getById(id);
        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        this.abilityService.deleteAll(resume.getData().getAbilities());
        this.imageService.deleteAll(resume.getData().getImages());
        this.schoolService.deleteAll(resume.getData().getSchools());
        this.jobExperienceService.deleteAll(resume.getData().getJobExperiences());
        this.languageService.deleteAll(resume.getData().getLanguages());
        this.resumeDao.delete(resume.getData());
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}

