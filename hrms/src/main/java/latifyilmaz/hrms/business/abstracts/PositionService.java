package latifyilmaz.hrms.business.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Position;
import latifyilmaz.hrms.entities.dtos.position.PositionSaveDto;

import java.util.List;

public interface PositionService {
    //Get
    DataResult<List<Position>> getAll();
    DataResult<Position> getById(int id);
    DataResult<Position> getByPositionName(String positionName);

    //Save
    Result save(PositionSaveDto position);

    //Delete
    Result delete(Position position);
    Result deleteById(int id);
}
