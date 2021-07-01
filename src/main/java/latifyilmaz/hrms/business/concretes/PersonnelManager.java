package latifyilmaz.hrms.business.concretes;


import latifyilmaz.hrms.business.abstracts.PersonnelService;
import latifyilmaz.hrms.business.abstracts.UserService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.helpers.EmailService;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.core.utilities.tools.StringTools;
import latifyilmaz.hrms.dataAccess.abstracts.PersonnelDao;
import latifyilmaz.hrms.entities.concretes.Employee;
import latifyilmaz.hrms.entities.concretes.Personnel;
import latifyilmaz.hrms.entities.concretes.User;
import latifyilmaz.hrms.entities.dtos.personnel.PersonnelSaveDto;
import latifyilmaz.hrms.entities.dtos.personnel.PersonnelUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelManager implements PersonnelService {
    private final PersonnelDao personnelDao;
    private final UserService userService;
    private final EmailService emailService;
    private final String FIELD = "personnel";

    @Autowired
    public PersonnelManager(PersonnelDao personnelDao, UserService userService, EmailService emailService){
        this.personnelDao = personnelDao;
        this.userService = userService;
        this.emailService = emailService;
    }


    //Get
    public DataResult<List<Personnel>> getAll() {
        return new SuccessDataResult<List<Personnel>>(this.personnelDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Personnel> getById(int id) {
        return new SuccessDataResult<Personnel>(this.personnelDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<Personnel> getByEmail(String email) {
        return new SuccessDataResult<Personnel>(this.personnelDao.getByUser_Email(email), MessageResults.dataListed(FIELD));
    }

    public Result save(PersonnelSaveDto personnel) {
        if (StringTools.isStringNullOrEmpty(personnel.getFirstName()) ||
                StringTools.isStringNullOrEmpty(personnel.getLastName()) ||
                StringTools.isStringNullOrEmpty(personnel.getEmail()) ||
                StringTools.isStringNullOrEmpty(personnel.getPassword()) ||
                StringTools.isStringNullOrEmpty(personnel.getPasswordRetry())){
            return new ErrorResult(MessageResults.emptyFields);
        }

        if(!personnel.getPassword().equals(personnel.getPasswordRetry())){
            return new ErrorResult(MessageResults.passwordMatchFalse);
        }

        boolean checkEmail = emailService.check(personnel.getEmail()).isSuccess();
        if(!checkEmail){
            return new ErrorResult(MessageResults.isEmailFormatFalse);
        }

        User byEmail = userService.getByEmail(personnel.getEmail()).getData();

        if(byEmail != null){
            return new ErrorResult(MessageResults.alreadyExists("email"));
        }

        User user = new User(
                personnel.getEmail(),
                personnel.getPassword(),
                true,
                "personnel"
        );
        userService.save(user);

        Personnel personnelObject = new Personnel(
                user.getId(),
                personnel.getFirstName(),
                personnel.getLastName()
        );

        this.personnelDao.save(personnelObject);

        return new SuccessResult(MessageResults.saved(FIELD));
    }

    public Result updateById(PersonnelUpdateDto personnel) {
        this.personnelDao.updateById(personnel.getUserId(), personnel.getFirstName(), personnel.getLastName());
        return new SuccessResult(MessageResults.updated(FIELD));
    }

    public Result delete(Personnel personnel) {
        this.personnelDao.delete(personnel);
        this.userService.delete(personnel.getUser());
        return new SuccessResult(MessageResults.deleted(FIELD));
    }

    public Result deleteById(int id) {
        this.personnelDao.deleteById(id);
        this.userService.deleteById(id);
        return new SuccessResult(MessageResults.deleted(FIELD));
    }
}
