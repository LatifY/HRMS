package latifyilmaz.hrms.core.utilities.helpers;

import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.ErrorResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.core.utilities.results.SuccessResult;
import latifyilmaz.hrms.entities.concretes.User;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailManager implements EmailService {


    public Result send(User user) {
        return new SuccessResult(MessageResults.emailSent(user.getEmail()));
    }

    public Result check(String email){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    public Result checkWithDomain(String email, String website) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + Pattern.quote(website) + "$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches()){
            return new SuccessResult();
        }
        return new ErrorResult();
    }
}
