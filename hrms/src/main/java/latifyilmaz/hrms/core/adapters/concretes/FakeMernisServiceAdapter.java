package latifyilmaz.hrms.core.adapters.concretes;

import latifyilmaz.hrms.core.adapters.abstracts.UserCheckService;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class FakeMernisServiceAdapter implements UserCheckService {
    public boolean isRealPerson(String tcNo, String firstName, String lastName, int dateOfBirthYear) {
        return true;
    }
}