package latifyilmaz.hrms.business.concretes;


import latifyilmaz.hrms.business.abstracts.PersonelService;
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

    @Autowired
    public PersonelManager(PersonelDao personelDao){
        super();
        this.personelDao = personelDao;
    }


    //Get
    public DataResult<List<Personel>> getAll() {
        return new SuccessDataResult<List<Personel>>(this.personelDao.findAll(), "All Personel data listed.");
    }

    public DataResult<Personel> getById(int id) {
        return new SuccessDataResult<Personel>(this.personelDao.findById(id).get(), "Personel data listed.");
    }
}
