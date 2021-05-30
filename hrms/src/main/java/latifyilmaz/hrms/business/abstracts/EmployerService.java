package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Employer;
import latifyilmaz.hrms.entities.dtos.employer.EmployerSaveDto;

import java.util.List;

public interface EmployerService {
    //Get (GET)
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
    DataResult<Employer> getByEmail(String email);

    Result save(EmployerSaveDto employer);
}
