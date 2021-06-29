package latifyilmaz.hrms.entities.dtos.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelUpdateDto {
    private int userId;
    private String firstName;
    private String lastName;
}
