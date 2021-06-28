package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.School;
import latifyilmaz.hrms.entities.dtos.school.SchoolSaveDto;

import java.util.List;

public interface SchoolService {
    //Get
    DataResult<List<School>> getAll();
    DataResult<List<School>> getAllByResumeId(int resumeId);
    DataResult<School> getById(int id);
    DataResult<List<School>> getByIds(List<Integer> ids);

    //Post
    Result save(SchoolSaveDto school);

    //Delete
    Result delete(School school);
    Result deleteById(int id);
    Result deleteByIds(List<Integer> ids);
    Result deleteAll(List<School> schools);
}
