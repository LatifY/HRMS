package latifyilmaz.hrms.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import latifyilmaz.hrms.business.constants.MessageResults;
import latifyilmaz.hrms.core.adapters.abstracts.PictureUploadService;
import latifyilmaz.hrms.core.utilities.results.DataResult;
import latifyilmaz.hrms.core.utilities.results.ErrorDataResult;
import latifyilmaz.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryServiceAdapter implements PictureUploadService {

    private final Cloudinary cloudinary;
    private final Map<String, String> config = new HashMap<>();

    public CloudinaryServiceAdapter(){
        config.put("cloud_name", "");
        config.put("api_key", "");
        config.put("api_secret", "");
        cloudinary = new Cloudinary(config);
    }

    public DataResult<Map<String, String>> upload(MultipartFile multiPartFile) {
        File file;

        try{
            file = convert(multiPartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<Map<String, String>>(result);
        }
        catch (IOException exception){
            exception.printStackTrace();
            return new ErrorDataResult<Map<String, String>>(MessageResults.errorWhileUploadingFile);
        }
    }

    public DataResult<Map> delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return new SuccessDataResult<Map>(result);
    }

    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();
        return file;
    }
}
