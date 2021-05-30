package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.ErrorDataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.PositionDao;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;
    private String FIELD = "position";

    @Autowired
    public PositionManager(PositionDao positionDao){
        super();
        this.positionDao = positionDao;
    }

    //Save
    public DataResult<Position> save(Position position) {
        if(getByPositionName(position.getPositionName()).getData() != null){
            return new ErrorDataResult<Position>(position, MessageResults.alreadyExists(FIELD));
        }
        positionDao.save(position);
        return new SuccessDataResult<Position>(position, MessageResults.saved(FIELD));
    }

    //Delete
    public DataResult<Position> delete(Position position){
        positionDao.delete(position);
        return new SuccessDataResult<Position>(position, MessageResults.deleted(FIELD));
    }

    public DataResult<Integer> deleteById(int id){
        positionDao.deleteById(id);
        return new SuccessDataResult<Integer>(id, MessageResults.deleted(FIELD));
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
}
