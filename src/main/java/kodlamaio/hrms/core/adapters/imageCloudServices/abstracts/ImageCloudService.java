package kodlamaio.hrms.core.adapters.imageCloudServices.abstracts;


import org.springframework.web.multipart.MultipartFile;

public interface ImageCloudService {

	String upload(MultipartFile image);
}
