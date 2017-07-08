package th.ac.hcu.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import th.ac.hcu.security.AuthenticatedUsers;
import th.ac.hcu.security.TokenAuthenticationService;
import th.ac.hcu.service.MaoUserDetailService;
import th.ac.hcu.service.UserService;

@Controller
@RequestMapping(value = "/service")
public class UserServiceController {
	
	  private final Logger log = LoggerFactory.getLogger(this.getClass());	
	  
	  @Autowired UserService userService;
	  
	  @Autowired MaoUserDetailService userDetailsService;
	  
	  @Autowired TokenAuthenticationService tokenService;
	  
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
	  
	  @RequestMapping(value = "/xxx", method = RequestMethod.GET)
	  @ResponseBody
	  public String xxx(HttpServletRequest request) throws Exception {
		  return "dddd";
	  }
}
