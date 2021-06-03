package latifyilmaz.hrms.business.abstracts;


import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Image;
import latifyilmaz.hrms.entities.dtos.image.ImageSaveDto;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
    DataResult<List<Image>> getByIds(List<Integer> ids);


    Result save(ImageSaveDto image);
}
