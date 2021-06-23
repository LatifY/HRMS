package latifyilmaz.hrms.entities.dtos.resume;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeSaveDto {
    private int employeeId;
    private String description;
    private String githubUrl;
    private String linkedinUrl;
}
