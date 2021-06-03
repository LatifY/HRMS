package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Language;
import latifyilmaz.hrms.entities.dtos.language.LanguageSaveDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();
    DataResult<Language> getById(int id);
    DataResult<List<Language>> getByIds(List<Integer> ids);

    Result save(LanguageSaveDto language);
}
