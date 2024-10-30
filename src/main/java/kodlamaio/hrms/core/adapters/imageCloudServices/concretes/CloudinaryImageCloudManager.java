package kodlamaio.hrms.core.adapters.imageCloudServices.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import io.github.cdimascio.dotenv.Dotenv;
import kodlamaio.hrms.core.adapters.imageCloudServices.abstracts.ImageCloudService;

@Service
public class CloudinaryImageCloudManager implements ImageCloudService{

	Dotenv dotenv = Dotenv.load();
	Cloudinary cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));

	@Override
	public String upload(MultipartFile image) {
		Map params1 = ObjectUtils.asMap(
			    "use_filename", true,
			    "unique_filename", true,
			    "overwrite", true
			);
		
		try {
			Map uploadResult = cloudinary.uploader().upload(image.getBytes(), params1);
			return uploadResult.get("display_name").toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
