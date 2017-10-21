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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import th.ac.hcu.constant.Constants;
import th.ac.hcu.entity.master.IpePatientPtStudent;
import th.ac.hcu.repository.master.PatientPtStudentRepository;

@Service
@Qualifier("ptStorageService")
public class PtStorageServiceImpl implements StorageService{

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired StartUp startUp;
	
	@Autowired PatientPtStudentRepository ptStudentRepository;
	
	@Override
	public void deleteFile(String transactionId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String saveFile(MultipartFile multipartFile, String ptId, String userName) {
		String pathFile = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("PATH").getInfoTh()+userName+"/"+ptId;
		String root = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("ROOT").getInfoTh();
		
		IpePatientPtStudent pt = ptStudentRepository.findOne(Long.valueOf(ptId));
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
			
			String savedPath = userName+"/"+ptId+"/"+fulldate+".png";
			pt.setImage(savedPath);
			ptStudentRepository.save(pt);
		} catch (IOException e) {
			e.printStackTrace();
			pathFile = "error";
		}
		
		return pathFile;
	}

	@Override
	public InputStream getFile(String ptId, String userName, String fileName) throws FileNotFoundException {
		String pathFile = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("PATH").getInfoTh()+userName+"/"+ptId;
		String root = startUp.getParameterConfig().get(Constants.PARAMETER_GROUP_NAME.DIR_FILE).get("ROOT").getInfoTh();
		File outputfile = new File(root+pathFile+"/"+fileName+".png");
		InputStream inputStream = new FileInputStream(outputfile);
		return inputStream;
	}

}
