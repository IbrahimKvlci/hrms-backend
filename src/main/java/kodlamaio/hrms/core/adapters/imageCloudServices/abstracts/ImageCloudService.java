package kodlamaio.hrms.core.adapters.imageCloudServices.abstracts;


import org.springframework.web.multipart.MultipartFile;

public interface ImageCloudService {
	
	String getImagePath(String imageName);
	String upload(MultipartFile image);
}
