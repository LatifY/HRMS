package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Ability;
import latifyilmaz.hrms.entities.dtos.ability.AbilitySaveDto;

import java.util.List;

public interface AbilityService {
    //Get
    DataResult<List<Ability>> getAll();
    DataResult<Ability> getById(int id);
    DataResult<List<Ability>> getByIds(List<Integer> ids);

    //Post
    Result save(AbilitySaveDto ability);

    //Delete
    Result delete(Ability ability);
    Result deleteById(int id);
    Result deleteByIds(List<Integer> ids);
    Result deleteAll(List<Ability> abilities);
}
