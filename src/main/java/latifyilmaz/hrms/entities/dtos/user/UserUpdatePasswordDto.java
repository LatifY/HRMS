package latifyilmaz.hrms.entities.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePasswordDto {
    private int id;
    private String oldPassword;
    private String newPassword;
    private String newPasswordRetry;
}
