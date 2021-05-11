package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.entities.concretes.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    //Save (POST)
    void save(Position position);

    //Delete (DELETE)
    void delete(Position position);

    List<Position> getAll();
    Optional<Position> getById(int id);
}
