package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.*;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.dataAccess.abstracts.ResumeDao;
import latifyilmaz.hrms.entities.concretes.*;
import latifyilmaz.hrms.entities.dtos.resume.ResumeSaveDto;
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

    public Result save(ResumeSaveDto resume) {
        List<Ability> abilitiesToAdd = abilityService.getByIds(resume.getAbilities()).getData();
        List<Image> imagesToAdd = imageService.getByIds(resume.getImages()).getData();
        List<School> schoolsToAdd = schoolService.getByIds(resume.getSchools()).getData();
        List<JobExperience> jobExperiencesToAdd = jobExperienceService.getByIds(resume.getJobExperiences()).getData();
        List<Language> languagesToAdd = languageService.getByIds(resume.getLanguages()).getData();

        DataResult<Employee> employee = employeeService.getById(resume.getEmployeeId());

        Resume resumeObject = new Resume(
                employee.getData(),
                resume.getGithubUrl(),
                resume.getLinkedinUrl(),
                resume.getDescription(),
                abilitiesToAdd,
                imagesToAdd,
                schoolsToAdd,
                jobExperiencesToAdd,
                languagesToAdd
        );

        this.resumeDao.save(resumeObject);

        return new SuccessResult(MessageResults.saved(FIELD));
    }
}

