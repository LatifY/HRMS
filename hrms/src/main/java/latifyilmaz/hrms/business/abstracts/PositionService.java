package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    List<Position> getAll();
}
