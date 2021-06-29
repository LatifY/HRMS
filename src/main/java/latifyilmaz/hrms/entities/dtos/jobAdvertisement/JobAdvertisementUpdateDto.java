package latifyilmaz.hrms.entities.dtos.jobAdvertisement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementUpdateDto {
    private int id;
    private String description;
    private int cityId;
    private int workingTimeId;
    private int positionId;
    private Date deadline;
    private int minSalary;
    private int maxSalary;
    private int openPositionsAmount;
}
