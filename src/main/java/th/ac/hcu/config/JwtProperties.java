package th.ac.hcu.config;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class JwtProperties {
	
	private final long jwtExpirationTime = 1000*60*10;
	
	private final String jwtSecret = "MaozcaptionitSuperSecret";
	
	private final String jwtSchema = "Bearer";
	
	private final String jwtHeader = "maoz-token";
	
//	private final String salt = KeyGenerators.string().generateKey();
	private final String salt = "8cbe18295de55596";
	
	public String getSalt() {
		return salt;
	}
	
	public long getJwtExpirationTime() {
		return jwtExpirationTime;
	}

	public String getJwtSecret() {
		return jwtSecret;
	}

	public String getJwtSchema() {
		return jwtSchema;
	}

	public String getJwtHeader() {
		return jwtHeader;
	}
}

