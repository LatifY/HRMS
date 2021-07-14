package latifyilmaz.hrms.entities.dtos.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitySaveMultipleDto {
    private List<String> cityNames;
}
