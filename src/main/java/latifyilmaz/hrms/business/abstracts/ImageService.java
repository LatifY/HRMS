package latifyilmaz.hrms.business.abstracts;


import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Image;
import latifyilmaz.hrms.entities.dtos.image.ImageSaveDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    //Get
    DataResult<List<Image>> getAll();
    DataResult<Image> getById(int id);
    DataResult<List<Image>> getByIds(List<Integer> ids);

    //Post
    Result save(int resumeId, MultipartFile file);

    //Delete
    Result delete(Image image);
    Result deleteById(int id);
    Result deleteByIds(List<Integer> ids);
    Result deleteAll(List<Image> images);
}
