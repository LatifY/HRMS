package latifyilmaz.hrms.entities.dtos.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String school_name;

    @NotEmpty
    @NotBlank
    private String school_department;

    @NotEmpty
    @NotBlank
    private int startYear;


    private int endYear;
}
