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

        DataResult<Resume> resume = resumeService.getById(language.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        Language languageObject = new Language(
                resume.getData(),
                language.getLanguageName(),
                language.getLanguageLevel()
        );

        this.languageDao.save(languageObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result delete(Language language) {
        this.languageDao.delete(language);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.languageDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteByIds(List<Integer> ids) {
        for (int id : ids){
            this.languageDao.deleteById(id);
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }

    public Result deleteAll(List<Language> languages) {
        for (var language : languages){
            this.languageDao.deleteById(language.getId());
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }
}
