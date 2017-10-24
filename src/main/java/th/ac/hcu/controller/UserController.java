package th.ac.hcu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import th.ac.hcu.bean.UserBean;
import th.ac.hcu.service.UserService;

@RestController
@RequestMapping(value = "/service")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public void addPatientProfile(HttpServletRequest request, 
			  				@RequestBody UserBean userBean) throws Exception {
		userService.addUser(userBean);
	}
}
