package com.sengmean.demo;

import com.sengmean.demo.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * Sengmean 01/04/2019
 */
@EnableAuthorizationServer
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repository) throws Exception{
//		builder.userDetailsService(new UserDetailsService() {
//			@Override
//			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//				return new CustomerDenials(repository.findByUsername(s));
//			}
//		});
//	}
}
