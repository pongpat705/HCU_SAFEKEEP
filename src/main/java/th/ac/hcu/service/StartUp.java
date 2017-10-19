package th.ac.hcu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import th.ac.hcu.constant.Constants.PARAMETER_GROUP_NAME;
import th.ac.hcu.constant.Role;
import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.entity.common.ParameterInfo;
import th.ac.hcu.repository.UserRepository;
import th.ac.hcu.repository.UserRoleRepository;
import th.ac.hcu.repository.common.ParameterInfoRepository;

@Component
@Order(2)
public class StartUp {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private ParameterInfoRepository paramInfoRepository;
	
	private Map<String, Map<String,ParameterInfo>> parameterConfig;
	
	private Map<String, List<ParameterInfo>> combos;
	
	 @PostConstruct
	 public void settingData(){
		initialRole();
		 loadParams();
		 loadCombos();
	 }
	 
	 public void initialRole(){
//		 log.info("inserting admin");
//			User adminUser = new User();
//			adminUser.setEnabled("1");
//			adminUser.setUserName("thisadmin");
//			adminUser.setPassword("password");
//			
//			userRepository.save(adminUser);
//			
//			UserRole adminRole = new UserRole();
//			adminRole.setEnabled("1");
//			adminRole.setRole(Role.ROLE_ADMIN);
//			adminRole.setUser(adminUser);
//			
//			userRoleRepository.save(adminRole);
//			
//			log.info("inserting prof");
//			User profUser = new User();
//			profUser.setEnabled("1");
//			profUser.setUserName("thisprof");
//			profUser.setPassword("password");
//			
//			userRepository.save(profUser);
//			
//			UserRole profRole = new UserRole();
//			profRole.setEnabled("1");
//			profRole.setRole(Role.ROLE_PROF);
//			profRole.setUser(profUser);
//			
//			userRoleRepository.save(profRole);
//			
//			log.info("inserting stud");
//			User stud = new User();
//			stud.setEnabled("1");
//			stud.setUserName("thisstud");
//			stud.setPassword("password");
//			
//			userRepository.save(stud);
//			
//			UserRole studRole = new UserRole();
//			studRole.setEnabled("1");
//			studRole.setRole(Role.ROLE_STUD);
//			studRole.setUser(stud);
//			
//			userRoleRepository.save(studRole);
		 
//			log.info("inserting patient");
//			User patient = new User();
//			patient.setEnabled("1");
//			patient.setUserName("thispatient");
//			patient.setPassword("password");
//			
//			userRepository.save(patient);
//			
//			UserRole patientRole = new UserRole();
//			patientRole.setEnabled("1");
//			patientRole.setRole(Role.ROLE_PATIEN);
//			patientRole.setUser(patient);
//			
//			userRoleRepository.save(patientRole);
			
//			log.info("inserting pt");
//			User stuPt = new User();
//			stuPt.setEnabled("1");
//			stuPt.setUserName("stupt");
//			stuPt.setPassword("password");
//			
//			userRepository.save(stuPt);
//			
//			UserRole stuPtRole = new UserRole();
//			stuPtRole.setEnabled("1");
//			stuPtRole.setRole(Role.ROLE_STUD_PT);
//			stuPtRole.setUser(stuPt);
//			
//			userRoleRepository.save(stuPtRole);
			
//			log.info("inserting ph");
//			User stuPh = new User();
//			stuPh.setEnabled("1");
//			stuPh.setUserName("stuph");
//			stuPh.setPassword("password");
//			
//			userRepository.save(stuPh);
//			
//			UserRole stuPhRole = new UserRole();
//			stuPhRole.setEnabled("1");
//			stuPhRole.setRole(Role.ROLE_STUD_PH);
//			stuPhRole.setUser(stuPh);
//			
//			userRoleRepository.save(stuPhRole);
	 }
	 
	 public void loadParams(){
		 	log.info("loading parameter");
			Sort sort = new Sort("groupCode");
			Pageable pageable = new PageRequest(0, 10000, sort);
			
			parameterConfig = new HashMap<>();
			
			for (String groupName : PARAMETER_GROUP_NAME.GROUPS()) {
				log.info("load group : "+groupName);
				Page<ParameterInfo> paramPage =  paramInfoRepository.findByGroupCode(pageable, groupName);
				
				Map<String,ParameterInfo> group = new HashMap<>();
				List<ParameterInfo> params = paramPage.getContent();
				for (ParameterInfo sysParameter : params) {
					log.info("load code : "+sysParameter.getInfoCode());
					group.put(sysParameter.getInfoCode(), sysParameter);
				}
				parameterConfig.put(groupName, group);
			}
	 }
	 
	 public void loadCombos(){
		 	log.info("loading combos");
			Sort sort = new Sort("groupCode");
			Pageable pageable = new PageRequest(0, 10000, sort);
			
			combos = new HashMap<>();
			
			for (String groupName : PARAMETER_GROUP_NAME.COMBOS()) {
				log.info("load combo : "+groupName);
				Page<ParameterInfo> paramPage =  paramInfoRepository.findByGroupCode(pageable, groupName);
				combos.put(groupName, paramPage.getContent());
			}
	 }
	 
	 public Map<String, Map<String, ParameterInfo>> getParameterConfig() {
			return parameterConfig;
	 }

	public Map<String, List<ParameterInfo>> getCombos() {
		return combos;
	}
	 
}
