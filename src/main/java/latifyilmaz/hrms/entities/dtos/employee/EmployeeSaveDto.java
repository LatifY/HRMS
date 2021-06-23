package latifyilmaz.hrms.entities.dtos.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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

    private int positionId;
}
