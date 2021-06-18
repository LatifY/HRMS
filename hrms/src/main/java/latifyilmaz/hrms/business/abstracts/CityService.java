package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.City;
import latifyilmaz.hrms.entities.dtos.city.CitySaveDto;

import java.util.List;

public interface CityService {
    //Get
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);

    //Post
    Result save(CitySaveDto city);

    //Delete
    Result delete(City city);
    Result deleteById(int id);

}
