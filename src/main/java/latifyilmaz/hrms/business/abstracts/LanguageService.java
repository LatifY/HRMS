package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Language;
import latifyilmaz.hrms.entities.dtos.language.LanguageSaveDto;

import java.util.List;

public interface LanguageService {
    //Get
    DataResult<List<Language>> getAll();
    DataResult<Language> getById(int id);
    DataResult<List<Language>> getByIds(List<Integer> ids);

    //Post
    Result save(LanguageSaveDto language);

    //Delete
    Result delete(Language language);
    Result deleteById(int id);
    Result deleteByIds(List<Integer> ids);
    Result deleteAll(List<Language> languages);
}
