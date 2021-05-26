package latifyilmaz.hrms.core.utilities.helpers;

import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.abstracts.User;

public interface EmailService {
    Result send(User user);
    Result check(String email);
    Result checkWithDomain(String email, String website);
}
