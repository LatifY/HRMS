package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Personnel;

import java.util.List;

public interface PersonnelService {
    //Get (GET)
    DataResult<List<Personnel>> getAll();
    DataResult<Personnel> getById(int id);
}
