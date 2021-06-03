package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.resume.ResumeSaveDto;

import java.util.List;

public interface ResumeService {
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getById(int id);

    Result save(ResumeSaveDto resume);
}
