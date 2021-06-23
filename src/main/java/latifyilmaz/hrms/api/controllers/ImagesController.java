package latifyilmaz.hrms.api.controllers;

import latifyilmaz.hrms.business.abstracts.ImageService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.Result;
import latifyilmaz.hrms.entities.concretes.Image;
import latifyilmaz.hrms.entities.dtos.image.ImageSaveDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
    private final ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService){
        this.imageService = imageService;
    }

    //Get
    @GetMapping("")
    public DataResult<List<Image>> getAll() {
        return this.imageService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Image> getById(@PathVariable(value = "id") int id) {
        return this.imageService.getById(id);
    }


    //Post
    @PostMapping("")
    public Result save(@RequestParam int resumeId, @RequestBody MultipartFile file){
        return this.imageService.save(resumeId, file);
    }


    //Delete
    @DeleteMapping("")
    public Result delete(@RequestBody Image image){
        return this.imageService.delete(image);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") int id){
        return this.imageService.deleteById(id);
    }
}
