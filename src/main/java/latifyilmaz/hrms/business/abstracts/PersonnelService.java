package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Personnel;
import latifyilmaz.hrms.entities.dtos.personnel.PersonnelSaveDto;

import java.util.List;

public interface PersonnelService {
    //Get
    DataResult<List<Personnel>> getAll();
    DataResult<Personnel> getById(int id);
    DataResult<Personnel> getByEmail(String email);

    //Post
    Result save(PersonnelSaveDto personnel);

    //Delete
    Result delete(Personnel personnel);
    Result deleteById(int id);
}
