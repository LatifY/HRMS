package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.CityService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.CityDao;
import latifyilmaz.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {
    private CityDao cityDao;
    private String FIELD = "city";

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
}
