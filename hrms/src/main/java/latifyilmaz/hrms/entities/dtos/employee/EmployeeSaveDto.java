package latifyilmaz.hrms.entities.dtos.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSaveDto {
    private String firstName;
    private String lastName;
    private String identityNo;
    private int birthYear;
    private String email;
    private String password;
    private String passwordRetry;
}
