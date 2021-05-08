package com.example.Assignment_6.Security_Config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class Spring_Securtiy_Config extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("User")
		.password("Password")
		.roles("User")
		.and()
		.withUser("foo")
		.password("Password1")
		.roles("Admin");
	}
	
	
	@Bean
	public PasswordEncoder getPasswordEncodder() { return NoOpPasswordEncoder.getInstance();
		
	//@Override
//	protected void Configure(HttpSecurity http) throws Exception {
//		
//	
//	}
}
}