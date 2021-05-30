package latifyilmaz.hrms.business.concretes;


import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.PersonnelDao;
import latifyilmaz.hrms.entities.concretes.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelManager implements PersonnelService {
    private PersonnelDao personnelDao;
    private String FIELD = "personel";

    @Autowired
    public PersonnelManager(PersonnelDao personnelDao){
        super();
        this.personnelDao = personnelDao;
    }


    //Get
    public DataResult<List<Personnel>> getAll() {
        return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Personnel> getById(int id) {
        return new SuccessDataResult<Personnel>(this.personnelDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }
}
