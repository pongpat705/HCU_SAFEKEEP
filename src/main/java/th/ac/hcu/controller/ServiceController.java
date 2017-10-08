package th.ac.hcu.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import th.ac.hcu.service.UserService;

@RestController
@RequestMapping(value = "/service")
public class ServiceController {
	
	  private final Logger log = LoggerFactory.getLogger(this.getClass());	
	  
	  @Autowired UserService userService;
	  
	  @Autowired MaoUserDetailService userDetailsService;
	  
	  @Autowired TokenAuthenticationService tokenService;
	  
	  @Autowired StartUp startUp;
	  
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
	  
	  @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	  @ResponseBody
	  public void uploadImage(HttpServletRequest request, 
			  				@RequestParam(name="file") MultipartFile file) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
	  }
}
