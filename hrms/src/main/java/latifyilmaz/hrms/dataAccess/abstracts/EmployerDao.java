package latifyilmaz.hrms.dataAccess.abstracts;

import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
    DataResult<Employer> findByEmail(String email);
}
