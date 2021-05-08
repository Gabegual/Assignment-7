package com.example.Assignment_7_Fianl.Security_Config;

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
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
	    .authorizeRequests()
	    .antMatchers("/Welcome").permitAll()
	    .anyRequest().authenticated();
	
	}
	@Bean
	public PasswordEncoder getPasswordEncodder() { return NoOpPasswordEncoder.getInstance();
		
	}
}