package th.ac.hcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.hcu.bean.UserBean;
import th.ac.hcu.config.JwtProperties;
import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.repository.UserRepository;
import th.ac.hcu.repository.UserRoleRepository;
import th.ac.hcu.service.UserService;

@RestController
@RequestMapping(value = "/service")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository roleRepository;
	
	private JwtProperties jwtProperties = new JwtProperties();
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public void addUser(HttpServletRequest request, 
			  				@RequestBody UserBean userBean) throws Exception {
		userService.addUser(userBean);
	}
	
	@RequestMapping(value = "/patchUser/{userId}", method = RequestMethod.PATCH)
	public void patchUser(HttpServletRequest request, 
			  				@RequestBody UserBean userBean,
			  				@PathVariable(name="userId") Long userId) throws Exception {
		userService.patchUser(userBean, userId);
	}
	@RequestMapping(value = "/deleteUsers/{userId}", method = RequestMethod.PATCH)
	public void deleteUsers(HttpServletRequest request, 
			  				@PathVariable(name="userId") Long userId) throws Exception {
		User user = userRepository.findOne(userId);
		for (UserRole xRole : user.getUserRole()) {
			roleRepository.delete(xRole);
		}
		userRepository.delete(userId);
	}
	
	@RequestMapping(value = "/getUserForPatch/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<UserBean> getUserForPatch(HttpServletRequest request, 
			@PathVariable(name="userId") Long userId) throws Exception {
		User user = userRepository.findOne(userId);
		UserBean userBean = new UserBean();
		userBean.setAdvisor(user.getAdvisor());
		userBean.setHospital(user.getHospital());
		userBean.setMajor(user.getMajor());
		userBean.setName(user.getName());
		
		TextEncryptor encrypted = Encryptors.queryableText(jwtProperties.getJwtSecret(), jwtProperties.getSalt());
		userBean.setPassword(encrypted.decrypt(user.getPassword()));
		
		userBean.setStudentId(user.getStudentId());
		userBean.setUserName(user.getUserName());
		userBean.setYears(user.getYears());
		List<String> role = new ArrayList<String>();
		userBean.setRole(role);
		for (UserRole xRole : user.getUserRole()) {
			userBean.getRole().add(xRole.getRole().name());
		}
		
		return new ResponseEntity<UserBean>(userBean, HttpStatus.OK);
	}
}
