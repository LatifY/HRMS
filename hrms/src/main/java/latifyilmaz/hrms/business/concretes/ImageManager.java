package latifyilmaz.hrms.business.concretes;

import latifyilmaz.hrms.business.abstracts.ImageService;
import latifyilmaz.hrms.business.abstracts.ResumeService;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.utilities.results.*;
import latifyilmaz.hrms.dataAccess.abstracts.ImageDao;
import latifyilmaz.hrms.entities.concretes.Image;
import latifyilmaz.hrms.entities.concretes.Resume;
import latifyilmaz.hrms.entities.dtos.image.ImageSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageManager implements ImageService {

    private final ImageDao imageDao;
    private final ResumeService resumeService;
    private final String FIELD = "image";


    @Autowired
    public ImageManager(ImageDao imageDao, ResumeService resumeService){
        this.imageDao = imageDao;
        this.resumeService = resumeService;
    }

    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), MessageResults.allDataListed(FIELD));
    }

    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>(this.imageDao.findById(id).get(), MessageResults.dataListed(FIELD));
    }

    public DataResult<List<Image>> getByIds(List<Integer> ids) {
        List<Image> images = new ArrayList<>();

        for(var id : ids){
            DataResult<Image> imageDataResult = getById(id);
            if(imageDataResult.isSuccess()){
                images.add(imageDataResult.getData());
            }
        }

        return new SuccessDataResult<List<Image>>(images, MessageResults.allDataListed(FIELD));
    }

    public Result save(ImageSaveDto image) {
        DataResult<Resume> resume = resumeService.getById(image.getResumeId());

        if(!resume.isSuccess()){
            return new ErrorResult(MessageResults.notFound(FIELD));
        }

        Image imageObject = new Image(
                resume.getData(),
                image.getImageUrl()
        );

        this.imageDao.save(imageObject);
        return new SuccessResult(MessageResults.saved(FIELD));
    }
}
