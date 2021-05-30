package latifyilmaz.hrms.entities.dtos.employer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerSaveDto {
    private String companyName;
    private String website;
    private String phone;
    private String email;
    private String password;
    private String passwordRetry;
}
