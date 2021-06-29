package latifyilmaz.hrms.entities.dtos.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerUpdateDto {
    private int userId;
    private String companyName;
    private String website;
    private String phone;
}
