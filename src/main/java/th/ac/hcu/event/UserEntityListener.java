package th.ac.hcu.event;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import th.ac.hcu.config.JwtProperties;
import th.ac.hcu.entity.User;

public class UserEntityListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	private JwtProperties jwtProperties = new JwtProperties();
	
	@PrePersist
	@PreUpdate
	public void methodExecuteBeforeSave(final User user) {
		log.info("Encrypting");
		log.info("salt:"+jwtProperties.getSalt());
		TextEncryptor encrypted = Encryptors.queryableText(jwtProperties.getJwtSecret(), jwtProperties.getSalt());
		
		log.info("key : "+jwtProperties.getJwtSecret());
		log.info("value :"+user.getPassword());
		log.info("result:"+encrypted.encrypt(user.getPassword()));
		
		user.setPassword(encrypted.encrypt(user.getPassword()));
	}
}
