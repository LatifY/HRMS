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
    @NotEmpty
    @NotBlank
    private String firstName;

    @NotEmpty
    @NotBlank
    private String lastName;

    @NotEmpty
    @NotBlank
    private String identityNo;

    @NotEmpty
    @NotBlank
    private int birthYear;

    @NotEmpty
    @NotBlank
    private String email;

    @NotEmpty
    @NotBlank
    private String password;

    @NotEmpty
    @NotBlank
    private String passwordRetry;

    @NotEmpty
    @NotBlank
    private int positionId;
}
