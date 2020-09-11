package com.ibm.shoponline.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		System.out.println("***In side configure----ResourceServerSecurityConfigurer resources**");
		resources.resourceId(RESOURCE_ID).stateless(false);
	}
	
	/* @Bean
	    ServletRegistrationBean h2servletRegistration(){
	        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
	        registrationBean.addUrlMappings("/h2/*");
	        return registrationBean;
	    }*/
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("***In side configure----HttpSecurity http**");
		
		  http.
          anonymous().disable()
          .authorizeRequests()          
          .antMatchers("/h2/**").permitAll()
          .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}

}