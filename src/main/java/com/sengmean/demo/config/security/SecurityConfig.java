///**
// * 
// */
//package com.sengmean.demo.config.security;
//
//import java.util.Arrays;
//
//import org.springframework.cglib.core.Customizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import io.swagger.models.HttpMethod;
//import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
//import springfox.documentation.builders.OAuthBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.service.AuthorizationScope;
//import springfox.documentation.service.GrantType;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.service.SecurityScheme;
//import springfox.documentation.service.TokenEndpoint;
//import springfox.documentation.service.TokenRequestEndpoint;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//
///**
// * 
// */
//@Configuration
//public class SecurityConfig {
//	
//	  @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		  
//      return http.build();
//  }
//	    
//	
//}
