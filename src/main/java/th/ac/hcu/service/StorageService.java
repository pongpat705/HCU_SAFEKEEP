package th.ac.hcu.service;

import java.io.FileNotFoundException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	public void deleteFile(String transactionId);
	
	public String saveFile(MultipartFile multipartFile, String transactionId, String userName);
	
	public InputStream getFile(String transactionId, String userName, String fileName) throws FileNotFoundException;
}
