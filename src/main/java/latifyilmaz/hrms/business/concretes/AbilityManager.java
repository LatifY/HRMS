package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.AbilityService;
import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.dataAccess.abstracts.AbilityDao;
import latifyilmaz.hrms.entities.concretes.Ability;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.ability.AbilitySaveDto;
import latifyilmaz.hrms.entities.dtos.ability.AbilityUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private final AbilityDao abilityDao;
    private final ResumeService resumeService;
    private final String FIELD = "ability";


    @Autowired
    public AbilityManager(AbilityDao abilityDao, ResumeService resumeService){
        this.abilityDao = abilityDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<List<Ability>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.getAllByResume_Id(resumeId), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Ability> getById(int id) {
        return new SuccessDataResult<Ability>(this.abilityDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Ability>> getByIds(List<Integer> ids) {
        List<Ability> abilities = new ArrayList<>();

        for(var id : ids){
            DataResult<Ability> abilityDataResult = getById(id);
            if(abilityDataResult.isSuccess()){
               abilities.add(abilityDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Ability>>(abilities, MessageResults.allDataListed(FIELD));
    }

    public Result save(AbilitySaveDto ability) {
        DataResult<Resume> resume = resumeService.getById(ability.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        Ability abilityObject = new Ability(
            resume.getData(),
            ability.getAbilityName()
        );

        this.abilityDao.save(abilityObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result updateById(AbilityUpdateDto ability) {
        this.abilityDao.updateById(ability.getId(), ability.getAbilityName());
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result delete(Ability ability) {
        this.abilityDao.delete(ability);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.abilityDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteByIds(List<Integer> ids) {
        for (int id : ids){
            this.abilityDao.deleteById(id);
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }

    public Result deleteAll(List<Ability> abilities) {
        for (var ability : abilities){
            this.abilityDao.deleteById(ability.getId());
        }
        return new SuccessResult(MessageResults.deleteds(FIELD));
    }
}
