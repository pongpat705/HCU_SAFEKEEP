package th.ac.hcu.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import th.ac.hcu.entity.common.ParameterInfo;
import th.ac.hcu.security.AuthenticatedUsers;
import th.ac.hcu.security.TokenAuthenticationService;
import th.ac.hcu.service.MaoUserDetailService;
import th.ac.hcu.service.StartUp;
import th.ac.hcu.service.StorageService;
import th.ac.hcu.service.UserService;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
	
	  private final Logger log = LoggerFactory.getLogger(this.getClass());	
	  
	  @Autowired UserService userService;
	  
	  @Autowired MaoUserDetailService userDetailsService;
	  
	  @Autowired TokenAuthenticationService tokenService;
	  
	  @Autowired StartUp startUp;
	  
	  @Autowired @Qualifier("storageService")StorageService storageService;
	  
	  @Autowired @Qualifier("ptStorageService") StorageService ptStorageService;
	  
	  @Autowired @Qualifier("mapStorageService") StorageService mapStorageService;

	  @Autowired @Qualifier("ecoStorageService") StorageService ecoStorageService;
	  
	  @Autowired @Qualifier("genoStorageService") StorageService genoStorageService;
	  
	  @RequestMapping(value = "/parse", method = RequestMethod.GET)
	  @ResponseBody
	  public AuthenticatedUsers parse(HttpServletRequest request) throws Exception {
		  String token = request.getHeader("maoz-token");
		  log.info("parsing token : "+token);
	    try {
	    	AuthenticatedUsers authenUsers = tokenService.parseToken(request);
		    return authenUsers;
	    }
	    catch (Exception ex) {
	      throw new Exception("Error parsing the token: " + ex.toString());
	    }
	  }
	  
	  @RequestMapping(value = "/getCombos", method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<Map<String, List<ParameterInfo>>> getCombos(){
		return new ResponseEntity<Map<String,List<ParameterInfo>>>(startUp.getCombos(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = "/getParams", method = RequestMethod.GET)
	  @ResponseBody
	  public ResponseEntity<Map<String, Map<String,ParameterInfo>>> getParams(){
		return new ResponseEntity<Map<String, Map<String,ParameterInfo>>>(startUp.getParameterConfig(), HttpStatus.OK);
	  }
	  
	  @RequestMapping(value = "/isAuthen", method = RequestMethod.GET)
	  @ResponseBody
	  public String isAuthen(HttpServletRequest request) {
		  log.info("calling from "+request.getRemoteAddr());
		  return "{\"ipAddress\":\""+request.getRemoteAddr()+"\"}";
	  }
	  
	  @RequestMapping(value = "/uploadImage/{transactionId}/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	  @ResponseBody
	  public ResponseEntity<Map<String, String>> uploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file, @PathVariable("transactionId") String transactionId, @PathVariable("userId") String userId) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
		  log.info("transactionId : "+transactionId);
		  log.info("userId : "+userId);
		  Map<String, String> map = new HashMap<>();
		  String pathFile = storageService.saveFile(file, transactionId, userId);
		  map.put("file", pathFile);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	  }
	  

	  @RequestMapping(value = "/viewImage/{userId}/{transactionId}/{fileName}", method = RequestMethod.GET)
	  @ResponseBody
	  public byte[] viewImage(HttpServletRequest request, @PathVariable("transactionId") String transactionId, @PathVariable("userId") String userId, @PathVariable("fileName") String fileName) throws IOException {
	      InputStream in = storageService.getFile(transactionId, userId, fileName);
	      BufferedImage originalImage=ImageIO.read(in);
	      ByteArrayOutputStream baos=new ByteArrayOutputStream();
	      ImageIO.write(originalImage, "jpg", baos );
	      byte[] imageInByte = baos.toByteArray();
	      return imageInByte;
	  }
	  
	  @RequestMapping(value = "/pt/uploadImage/{ptId}/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	  @ResponseBody
	  public ResponseEntity<Map<String, String>> ptUploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file, @PathVariable("ptId") String ptId, @PathVariable("userId") String userId) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
		  log.info("ptId : "+ptId);
		  log.info("userId : "+userId);
		  Map<String, String> map = new HashMap<>();
		  String pathFile = ptStorageService.saveFile(file, ptId, userId);
		  map.put("file", pathFile);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	  }
	  

	  @RequestMapping(value = "/pt/viewImage/{userId}/{ptId}/{fileName}", method = RequestMethod.GET)
	  @ResponseBody
	  public byte[] ptViewImage(HttpServletRequest request, @PathVariable("ptId") String ptId, @PathVariable("userId") String userId, @PathVariable("fileName") String fileName) throws IOException {
	      InputStream in = ptStorageService.getFile(ptId, userId, fileName);
	      BufferedImage originalImage=ImageIO.read(in);
	      ByteArrayOutputStream baos=new ByteArrayOutputStream();
	      ImageIO.write(originalImage, "jpg", baos );
	      byte[] imageInByte = baos.toByteArray();
	      return imageInByte;
	  }
	  
	  @RequestMapping(value = "/map/uploadImage/{patientId}/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	  @ResponseBody
	  public ResponseEntity<Map<String, String>> mapUploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file, @PathVariable("patientId") String patientId, @PathVariable("userId") String userId) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
		  log.info("patientId : "+patientId);
		  log.info("userId : "+userId);
		  Map<String, String> map = new HashMap<>();
		  String pathFile = mapStorageService.saveFile(file, patientId, userId);
		  map.put("file", pathFile);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	  }
	  

	  @RequestMapping(value = "/map/viewImage/{userId}/map/{patientId}/{fileName}", method = RequestMethod.GET)
	  @ResponseBody
	  public byte[] mapViewImage(HttpServletRequest request, @PathVariable("patientId") String ptId, @PathVariable("userId") String userId, @PathVariable("fileName") String fileName) throws IOException {
	      InputStream in = mapStorageService.getFile(ptId, userId, fileName);
	      BufferedImage originalImage=ImageIO.read(in);
	      ByteArrayOutputStream baos=new ByteArrayOutputStream();
	      ImageIO.write(originalImage, "jpg", baos );
	      byte[] imageInByte = baos.toByteArray();
	      return imageInByte;
	  }
	  
	  @RequestMapping(value = "/eco/uploadImage/{patientId}/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	  @ResponseBody
	  public ResponseEntity<Map<String, String>> ecoUploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file, @PathVariable("patientId") String patientId, @PathVariable("userId") String userId) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
		  log.info("patientId : "+patientId);
		  log.info("userId : "+userId);
		  Map<String, String> map = new HashMap<>();
		  String pathFile = ecoStorageService.saveFile(file, patientId, userId);
		  map.put("file", pathFile);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	  }
	  

	  @RequestMapping(value = "/eco/viewImage/{userId}/eco/{patientId}/{fileName}", method = RequestMethod.GET)
	  @ResponseBody
	  public byte[] ecoViewImage(HttpServletRequest request, @PathVariable("patientId") String patientId, @PathVariable("userId") String userId, @PathVariable("fileName") String fileName) throws IOException {
	      InputStream in = ecoStorageService.getFile(patientId, userId, fileName);
	      BufferedImage originalImage=ImageIO.read(in);
	      ByteArrayOutputStream baos=new ByteArrayOutputStream();
	      ImageIO.write(originalImage, "jpg", baos );
	      byte[] imageInByte = baos.toByteArray();
	      return imageInByte;
	  }
	  
	  @RequestMapping(value = "/geno/uploadImage/{patientId}/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
	  @ResponseBody
	  public ResponseEntity<Map<String, String>> genoUploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file, @PathVariable("patientId") String patientId, @PathVariable("userId") String userId) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
		  log.info("patientId : "+patientId);
		  log.info("userId : "+userId);
		  Map<String, String> map = new HashMap<>();
		  String pathFile = genoStorageService.saveFile(file, patientId, userId);
		  map.put("file", pathFile);
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.CREATED);
	  }
	  

	  @RequestMapping(value = "/geno/viewImage/{userId}/geno/{patientId}/{fileName}", method = RequestMethod.GET)
	  @ResponseBody
	  public byte[] genoViewImage(HttpServletRequest request, @PathVariable("patientId") String patientId, @PathVariable("userId") String userId, @PathVariable("fileName") String fileName) throws IOException {
	      InputStream in = genoStorageService.getFile(patientId, userId, fileName);
	      BufferedImage originalImage=ImageIO.read(in);
	      ByteArrayOutputStream baos=new ByteArrayOutputStream();
	      ImageIO.write(originalImage, "jpg", baos );
	      byte[] imageInByte = baos.toByteArray();
	      return imageInByte;
	  }
}
