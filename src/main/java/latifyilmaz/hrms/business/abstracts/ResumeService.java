package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.resume.ResumeSaveDto;

import java.util.List;

public interface ResumeService {
    //Get
    DataResult<List<Resume>> getAll();
    DataResult<Resume> getById(int id);
    DataResult<Resume> getByEmployeeId(int employeeId);

    //Post
    Result save(ResumeSaveDto resume);

    //Delete
    Result delete(Resume resume);
    Result deleteById(int id);
}
