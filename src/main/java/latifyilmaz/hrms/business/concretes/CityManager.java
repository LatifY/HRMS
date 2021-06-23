package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.CityService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessResult;
import latifyilmaz.hrms.dataAccess.abstracts.CityDao;
import latifyilmaz.hrms.entities.concretes.City;
import latifyilmaz.hrms.entities.dtos.city.CitySaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private final CityDao cityDao;
    private final String FIELD = "city";

    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao = cityDao;
    }

    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(this.cityDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public Result save(CitySaveDto city) {
        City cityObject = new City(city.getCityName());
        this.cityDao.save(cityObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result delete(City city) {
        this.cityDao.delete(city);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.cityDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
