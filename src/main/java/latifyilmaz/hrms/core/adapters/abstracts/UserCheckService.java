package latifyilmaz.hrms.core.adapters.abstracts;

import java.util.Date;

public interface UserCheckService {
    boolean isRealPerson(String identityNo, String firstName, String lastName, int birthYear);
}
