package th.ac.hcu.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import th.ac.hcu.bean.UserBean;
import th.ac.hcu.constant.Role;
import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.repository.UserRepository;
import th.ac.hcu.repository.UserRoleRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserRepository usersRepository;
	
	@Autowired UserRoleRepository userRoleRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	public String userToString(String userName){
    	User user = usersRepository.findByUserName(userName);
    	ObjectMapper mapper = new ObjectMapper();
    	String tramformed = "";
		try {
			tramformed = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
    	
		return tramformed;
    }
	
	public User getUser(String userName){
		log.info("get userBean of "+userName);
		User user = usersRepository.findByUserName(userName);
		return user;
	}
    
    public User stringToUsers(String usersString) {
    	ObjectMapper mapper = new ObjectMapper();
    	User users = null;
		try {
			users = mapper.readValue(usersString, User.class);
		} catch (JsonParseException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return users;
    }

    @Transactional
	@Override
	public void addUser(UserBean userBean) {
		// TODO Auto-generated method stub
		log.info("inserting ph");
		User user = new User();
		user.setEnabled("1");
		user.setName(userBean.getName());
		user.setUserName(userBean.getUserName());
		user.setPassword(userBean.getPassword());
		user.setStudentId(userBean.getStudentId());
		user.setMajor(userBean.getMajor());
		user.setYears(userBean.getYears());
		user.setHospital(userBean.getHospital());
		user.setAdvisor(userBean.getAdvisor());
		
		usersRepository.save(user);
		
		UserRole role = new UserRole();
		role.setEnabled("1");
		role.setRole(Role.valueOf(userBean.getRole()));
		role.setUser(user);
		
		userRoleRepository.save(role);
	}

}
