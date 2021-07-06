package latifyilmaz.hrms.entities.dtos.favoriteJob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteJobSaveDto {
    private int userId;
    private int jobAdvertisementId;
}
