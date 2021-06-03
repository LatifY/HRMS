package latifyilmaz.hrms.entities.dtos.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageSaveDto {
    private int resumeId;

    @NotEmpty
    @NotBlank
    private String imageUrl;
}
