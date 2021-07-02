package latifyilmaz.hrms.entities.dtos.jobAdvertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFilterDto {
    private String search;
    private int positionId;
    private int cityId;
    private int workingTimeId;
    private int minSalary;
    private int maxSalary;
}
