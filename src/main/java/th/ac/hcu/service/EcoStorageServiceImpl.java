package th.ac.hcu.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import th.ac.hcu.constant.Constants;
import th.ac.hcu.entity.master.IpePatientProfile;
import th.ac.hcu.repository.master.PatientProfileRepository;

@Service
@Qualifier("ecoStorageService")
public class EcoStorageServiceImpl implements StorageService {

	
	@Autowired StartUp startUp;
	
	@Autowired PatientProfileRepository profileRepository;
	
	@Override
	public void deleteFile(String transactionId) {
		// TODO Auto-generated method stub

	}

	@Override
	public String saveFile(MultipartFile multipartFile, String patientId, String userName) {
		String pathFile = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("PATH").getInfoTh()+userName+"/eco/"+patientId;
		String root = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("ROOT").getInfoTh();
		
		IpePatientProfile profile = profileRepository.findOne(Long.valueOf(patientId));
		try {
			InputStream is = multipartFile.getInputStream();
			BufferedImage buffImage = ImageIO.read(is);
			
			File dir = new File(root+pathFile);
			if(!dir.exists()){
				dir.mkdirs();
			}
			Date uploadDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(uploadDate);
			int day = calendar.get(Calendar.DATE);
			int mont = calendar.get(Calendar.MONTH)+1;
			int year = calendar.get(Calendar.YEAR);
			String fulldate = day+"-"+mont+"-"+year;
			
			File outputfile = new File(root+pathFile+"/"+fulldate+".png");
			outputfile.deleteOnExit();
			ImageIO.write(buffImage, "png", outputfile);
			
			String savedPath = userName+"/eco/"+patientId+"/"+fulldate+".png";
			profile.setsEcoMapImg(savedPath);
			profileRepository.save(profile);
		} catch (IOException e) {
			e.printStackTrace();
			pathFile = "error";
		}
		
		return pathFile;
	}

	@Override
	public InputStream getFile(String patientId, String userName, String fileName) throws FileNotFoundException {
		String pathFile = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("PATH").getInfoTh()+userName+"/eco/"+patientId;
		String root = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("ROOT").getInfoTh();
		File outputfile = new File(root+pathFile+"/"+fileName+".png");
		InputStream inputStream = new FileInputStream(outputfile);
		return inputStream;
	}

}
