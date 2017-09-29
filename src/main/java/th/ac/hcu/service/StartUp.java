package th.ac.hcu.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import th.ac.hcu.constant.Role;
import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.repository.UserRepository;
import th.ac.hcu.repository.UserRoleRepository;

@Component
@Order(2)
public class StartUp {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	 @PostConstruct
	 public void settingData(){
		initialRole();
	 }
	 
	 public void initialRole(){
		 log.info("inserting admin");
			User adminUser = new User();
			adminUser.setEnabled("1");
			adminUser.setUserName("pongpat705");
			adminUser.setPassword("password");
			
			userRepository.save(adminUser);
			
			UserRole adminRole = new UserRole();
			adminRole.setEnabled("1");
			adminRole.setRole(Role.ROLE_ADMIN);
			adminRole.setUser(adminUser);
			
			userRoleRepository.save(adminRole);
			
			log.info("inserting prof");
			User profUser = new User();
			profUser.setEnabled("1");
			profUser.setUserName("pongpat706");
			profUser.setPassword("password");
			
			userRepository.save(profUser);
			
			UserRole profRole = new UserRole();
			profRole.setEnabled("1");
			profRole.setRole(Role.ROLE_PROF);
			profRole.setUser(profUser);
			
			userRoleRepository.save(profRole);
			
			log.info("inserting stud");
			User stud = new User();
			stud.setEnabled("1");
			stud.setUserName("pongpat706");
			stud.setPassword("password");
			
			userRepository.save(stud);
			
			UserRole studRole = new UserRole();
			studRole.setEnabled("1");
			studRole.setRole(Role.ROLE_STUD);
			studRole.setUser(stud);
			
			userRoleRepository.save(studRole);
	 }
}
