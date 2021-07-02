package latifyilmaz.hrms.entities.dtos.jobAdvertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementFilterDto {
    private String search;
    private List<Integer> positionIds;
    private List<Integer> cityIds;
    private List<Integer> workingTimeIds;
    private int minSalary;
    private int maxSalary;
}
