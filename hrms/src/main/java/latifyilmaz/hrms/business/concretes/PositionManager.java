package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.dataAccess.abstracts.PositionDao;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.dtos.position.PositionSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService {
    private final PositionDao positionDao;
    private final String FIELD = "position";

    @Autowired
    public PositionManager(PositionDao positionDao){
        this.positionDao = positionDao;
    }

    //Get
    public DataResult<List<Position>>  getAll() {
        return new SuccessDataResult<List<Position>>(positionDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Position> getById(int id) {
        return new SuccessDataResult<Position>(positionDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Position> getByPositionName(String positionName) {
        return new SuccessDataResult<Position>(positionDao.getByPositionName(positionName), MessageResults.dataListed(FIELD));
    }

    //Save
    public Result save(PositionSaveDto position) {
        if(getByPositionName(position.getPositionName()).getData() != null){
            return new ErrorResult(MessageResults.alreadyExists(FIELD));
        }

        Position positionObject = new Position(position.getPositionName());
        this.positionDao.save(positionObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }

    //Delete
    public Result delete(Position position){
        this.positionDao.delete(position);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id){
        this.positionDao.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
