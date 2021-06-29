package latifyilmaz.hrms.entities.dtos.ability;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityUpdateDto {
    private int id;

    @NotEmpty
    @NotBlank
    private String abilityName;
}
