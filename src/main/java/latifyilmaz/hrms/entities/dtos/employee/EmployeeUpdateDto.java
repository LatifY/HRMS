package latifyilmaz.hrms.entities.dtos.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeUpdateDto {
    private int userId;
    private String firstName;
    private String lastName;
    private int birthYear;
    private int positionId;
}
