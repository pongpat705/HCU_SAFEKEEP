package th.ac.hcu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import th.ac.hcu.security.JWTAuthenticationFilter;
import th.ac.hcu.security.JWTLoginFilter;
import th.ac.hcu.service.MaoUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MaoUserDetailService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().disable();
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/scripts/**").permitAll()
			.antMatchers("/styles/**").permitAll()
			.antMatchers("/bower_components/**").permitAll()
			.antMatchers("/views/**").permitAll()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers("/service/**").permitAll()
			.antMatchers("/service/isAuthen").authenticated()
			.antMatchers("/api/**").authenticated()
//			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
	}

}
