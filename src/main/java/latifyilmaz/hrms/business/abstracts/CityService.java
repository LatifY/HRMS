package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.City;
import latifyilmaz.hrms.entities.dtos.city.CitySaveDto;
import latifyilmaz.hrms.entities.dtos.city.CitySaveMultipleDto;

import java.util.List;

public interface CityService {
    //Get
    DataResult<List<City>> getAll();
    DataResult<City> getById(int id);
    DataResult<City> getByCityName(String cityName);

    //Post
    Result save(CitySaveDto city);
    Result saveMultiple(CitySaveMultipleDto city);

    //Delete
    Result delete(City city);
    Result deleteById(int id);

}
