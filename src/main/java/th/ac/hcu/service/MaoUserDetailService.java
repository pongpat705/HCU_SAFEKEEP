package th.ac.hcu.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import th.ac.hcu.entity.User;
import th.ac.hcu.entity.UserRole;
import th.ac.hcu.repository.UserRepository;
import th.ac.hcu.security.Authorities;
import th.ac.hcu.security.CustomUserDetails;

@Service
public class MaoUserDetailService implements UserDetailsService {

	@Autowired UserRepository usersRepository;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = usersRepository.findByUserName(username);
		if (null == user){
			log.debug("user: "+username+" not found!");
			throw new UsernameNotFoundException("user: "+username+" not found!");
		}
		List<Authorities> gant = new ArrayList<Authorities>();
		
		if (user.getUserRole().isEmpty()){
			throw new UsernameNotFoundException("user: "+username+" roles not found!");
		}
		
		for (UserRole ur : user.getUserRole()) {
			Authorities ga = new Authorities(ur.getRole().name());
			gant.add(ga);
		}
		
		CustomUserDetails xx = new CustomUserDetails(user.getUserName(), user.getPassword(), null, gant);
		return xx;
	}
	
}
