package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import latifyilmaz.hrms.dataAccess.abstracts.PositionDao;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao){
        super();
        this.positionDao = positionDao;
    }

    //Save
    public DataResult<Position> save(Position position) {
        positionDao.save(position);
        return new SuccessDataResult<Position>(position, "Position added.");
    }

    //Delete
    public DataResult<Position> delete(Position position){
        positionDao.delete(position);
        return new SuccessDataResult<Position>(position,"Position deleted.");
    }

    public DataResult<Integer> deleteById(int id){
        positionDao.deleteById(id);
        return new SuccessDataResult<Integer>(id,"Position deleted.");
    }

    //Update
    public DataResult<Position> update(Position position) {
        positionDao.save(position);
        return new SuccessDataResult<Position>(position, "Position updated.");
    }


    //Get
    public DataResult<List<Position>>  getAll() {
        return new SuccessDataResult<List<Position>>(positionDao.findAll(), "All Position data listed");
    }

    public DataResult<Position> getById(int id) {
        return new SuccessDataResult<Position>(positionDao.findById(id).get(),"Position data listed.");
    }
}
