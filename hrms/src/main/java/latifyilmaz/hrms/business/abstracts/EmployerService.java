package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
    //Get (GET)
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
}
