package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Personel;

import java.util.List;

public interface PersonelService {
    //Get (GET)
    DataResult<List<Personel>> getAll();
    DataResult<Personel> getById(int id);
}
