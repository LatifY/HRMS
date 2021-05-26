package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Integer> {
    DataResult<Position> findByName(String name);
}
