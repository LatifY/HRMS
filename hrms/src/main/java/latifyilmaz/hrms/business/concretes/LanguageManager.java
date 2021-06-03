package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.LanguageService;
import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.LanguageDao;
import latifyilmaz.hrms.entities.concretes.Language;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.language.LanguageSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private final LanguageDao languageDao;
    private final ResumeService resumeService;
    private final String FIELD = "language";

    @Autowired
    private LanguageManager(LanguageDao languageDao, ResumeService resumeService){
        this.languageDao = languageDao;
        this.resumeService = resumeService;
    }


    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<Language>(this.languageDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Language>> getByIds(List<Integer> ids) {
        List<Language> languages = new ArrayList<>();

        for(var id : ids){
            DataResult<Language> languageDataResult = getById(id);
            if(languageDataResult.isSuccess()){
                languages.add(languageDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Language>>(languages, MessageResults.allDataListed(FIELD));
    }

    public Result save(LanguageSaveDto language) {
        if(StringTools.isStringNullOrEmpty(language.getLanguageName()) ||
                StringTools.isStringNullOrEmpty(String.valueOf(language.getLanguageLevel()))){
            return new ErrorResult(MessageResults.emptyFields);
        }

        //Resume resume = resumeService.getById(language.getResumeId()).getData();

        Language languageObject = new Language(
                new Resume(),
                language.getLanguageName(),
                language.getLanguageLevel()
        );

        this.languageDao.save(languageObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
