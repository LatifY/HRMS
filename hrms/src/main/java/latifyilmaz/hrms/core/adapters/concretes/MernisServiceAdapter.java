package latifyilmaz.hrms.core.adapters.concretes;

import latifyilmaz.hrms.core.adapters.abstracts.UserCheckService;
import latifyilmaz.hrms.services.MernisService.OGJKPSPublicSoap;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MernisServiceAdapter implements UserCheckService {
    public boolean isRealPerson(String identityNo, String firstName, String lastName, int birthYear) {
        OGJKPSPublicSoap soapClient = new OGJKPSPublicSoap();
        boolean checkResult = false;
        try{
            checkResult = soapClient.TCKimlikNoDogrula(Long.parseLong(identityNo), firstName, lastName, birthYear);
        }
        catch (Exception e){
            System.out.println("Mernis Error");
        }
        return checkResult;
    }
}
