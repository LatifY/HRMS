package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;

import java.util.List;

public interface EmployerService {
    //Get
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<Employer> getByEmail(String email);

    //Post
    Result save(EmployerSaveDto employer);

    //Delete
    Result delete(Employer employer);
    Result deleteById(int id);

}
