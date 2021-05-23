package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Position;

import java.util.List;

public interface PositionService {
    //Save (POST)
    DataResult<Position> save(Position position);

    //Delete (DELETE)
    DataResult<Position> delete(Position position);
    DataResult<Integer> deleteById(int id);

    //Update (PUT)
    DataResult<Position> update(Position position);

    //Get (GET)
    DataResult<List<Position>> getAll();
    DataResult<Position> getById(int id);
}
