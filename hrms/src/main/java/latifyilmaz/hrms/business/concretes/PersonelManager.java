package latifyilmaz.hrms.business.concretes;


import latifyilmaz.hrms.business.abstracts.PersonelService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.PersonelDao;
import latifyilmaz.hrms.entities.concretes.Personel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelManager implements PersonelService {
    private PersonelDao personelDao;
    private String FIELD = "personel";

    @Autowired
    public PersonelManager(PersonelDao personelDao){
        super();
        this.personelDao = personelDao;
    }


    //Get
    public DataResult<List<Personel>> getAll() {
        return new SuccessDataResult<List<Personel>>(this.personelDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Personel> getById(int id) {
        return new SuccessDataResult<Personel>(this.personelDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }
}
