package latifyilmaz.hrms.core.adapters.abstracts;

import java.util.Date;

public interface UserCheckService {
    boolean isRealPerson(String tcNo, String firstName, String lastName, int dateOfBirthYear);
}
