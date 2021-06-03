package latifyilmaz.hrms.entities.dtos.jobExperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String companyName;

    @NotEmpty
    @NotBlank
    private String positionName;

    @NotEmpty
    @NotBlank
    private int startYear;

    private int endYear;
}
