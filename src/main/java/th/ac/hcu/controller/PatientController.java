package th.ac.hcu.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.hcu.entity.master.IpePatientProfile;
import th.ac.hcu.repository.master.DrugListRepository;
import th.ac.hcu.repository.master.FamilyMemberRepository;
import th.ac.hcu.repository.master.PatientProfileRepository;
import th.ac.hcu.repository.master.UseDrugRepository;
import th.ac.hcu.repository.master.VisitLogRepository;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	  
	@Autowired
	private PatientProfileRepository profileRepository;
	@Autowired
	private VisitLogRepository visitLogRepository;
	@Autowired
	private FamilyMemberRepository familyMemberRepository;
	@Autowired
	private UseDrugRepository useDrugRepository;
	@Autowired
	private DrugListRepository drugListRepository;
	
	@RequestMapping(value = "/addPatientProfile", method = RequestMethod.POST)
	@ResponseBody
	public void addPatientProfile(HttpServletRequest request, 
			  				@RequestBody IpePatientProfile patientProfile) throws Exception {
		  log.info("calling from "+request.getRemoteAddr());
	}
}
