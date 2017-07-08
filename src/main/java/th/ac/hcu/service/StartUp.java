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
		
		log.info("inserting user");
		User userUser = new User();
		userUser.setEnabled("1");
		userUser.setUserName("pongpat706");
		userUser.setPassword("password");
		
		userRepository.save(userUser);
		
		UserRole userRole = new UserRole();
		userRole.setEnabled("1");
		userRole.setRole(Role.ROLE_USER);
		userRole.setUser(userUser);
		
		userRoleRepository.save(userRole);
	 }
}
