package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.abstracts.SchoolService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.SchoolDao;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.concretes.School;
import latifyilmaz.hrms.entities.dtos.school.SchoolSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private final SchoolDao schoolDao;
    private final ResumeService resumeService;
    private final String FIELD = "school";

    @Autowired
    public SchoolManager(SchoolDao schoolDao, ResumeService resumeService){
        this.schoolDao = schoolDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<School> getById(int id) {
        return new SuccessDataResult<School>(this.schoolDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<School>> getByIds(List<Integer> ids) {
        List<School> schools = new ArrayList<>();

        for(var id : ids){
            DataResult<School> schoolDataResult = getById(id);
            if(schoolDataResult.isSuccess()){
                schools.add(schoolDataResult.getData());
            }
        }

        return new SuccessDataResult<List<School>>(schools, MessageResults.allDataListed(FIELD));
    }

    public Result save(SchoolSaveDto school) {
        if(StringTools.isStringNullOrEmpty(school.getSchoolName()) ||
                StringTools.isStringNullOrEmpty(school.getSchoolDepartment()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(school.getStartYear()))){
            return new ErrorResult(MessageResults.emptyFields);
        }
        DataResult<Resume> resume = resumeService.getById(school.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        School schoolObject = new School(
                resume.getData(),
                school.getSchoolName(),
                school.getSchoolDepartment(),
                school.getStartYear(),
                school.getEndYear()
        );
        this.schoolDao.save(schoolObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result delete(School school) {
        this.schoolDao.delete(school);
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }

    public Result deleteById(int id) {
        this.schoolDao.deleteById(id);
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }

    public Result deleteByIds(List<Integer> ids) {
        for (int id : ids){
            this.schoolDao.deleteById(id);
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }

    public Result deleteAll(List<School> schools) {
        for (var school : schools){
            this.schoolDao.deleteById(school.getId());
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }
}
