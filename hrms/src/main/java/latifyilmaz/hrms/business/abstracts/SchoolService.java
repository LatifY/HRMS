package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.School;
import latifyilmaz.hrms.entities.dtos.school.SchoolSaveDto;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();
    DataResult<School> getById(int id);
    DataResult<List<School>> getByIds(List<Integer> ids);

    Result save(SchoolSaveDto school);
}
