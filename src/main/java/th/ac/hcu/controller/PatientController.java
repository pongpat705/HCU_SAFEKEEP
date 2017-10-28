package th.ac.hcu.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.hcu.entity.master.IpePatientProfile;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	  
	@RequestMapping(value = "/addPatientProfile", method = RequestMethod.POST)
	@ResponseBody
	public void addPatientProfile(HttpServletRequest request, 
			  				@RequestBody IpePatientProfile patientProfile) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
	}
}
