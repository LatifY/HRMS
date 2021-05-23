package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.PositionService;
import latifyilmaz.hrms.dataAccess.abstracts.PositionDao;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PositionManager implements PositionService {
    private PositionDao positionDao;

    @Autowired
    public PositionManager(PositionDao positionDao){
        super();
        this.positionDao = positionDao;
    }

    //Save
    public void save(Position position) {
        positionDao.save(position);
    }

    //Delete
    public void delete(Position position){
        positionDao.delete(position);
    }


    public void update(Position position) {
        positionDao.save(position);
    }


    //Get
    public List<Position> getAll() {
        return positionDao.findAll();
    }

    public Optional<Position> getById(int id) {
        return positionDao.findById(id);
    }
}
