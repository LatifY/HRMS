package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Ability;
import latifyilmaz.hrms.entities.dtos.ability.AbilitySaveDto;

import java.util.List;

public interface AbilityService {
    DataResult<List<Ability>> getAll();
    DataResult<Ability> getById(int id);
    DataResult<List<Ability>> getByIds(List<Integer> ids);

    Result save(AbilitySaveDto ability);
}
