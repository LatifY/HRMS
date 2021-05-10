package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.PositionService;
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


    public List<Position> getAll() {
        return positionDao.findAll();
    }
}
