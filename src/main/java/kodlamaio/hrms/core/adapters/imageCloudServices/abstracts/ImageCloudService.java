package kodlamaio.hrms.core.adapters.imageCloudServices.abstracts;


import org.springframework.web.multipart.MultipartFile;

public interface ImageCloudService {

	void upload(MultipartFile image,String name);
}
