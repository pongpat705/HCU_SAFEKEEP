package th.ac.hcu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SafeKeepApplication {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());	
	
	public static void main(String[] args) {
		SpringApplication.run(SafeKeepApplication.class, args);
	}
	
}
