package com.app.empdirectory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {
	@Bean
	public InMemoryUserDetailsManager userDetaisManager() {
		UserDetails abcd = User.builder().username("abcd").password("{noop}test123").roles("EMPLOYEE").build();

		UserDetails efgh = User.builder().username("efgh").password("{noop}test123").roles("EMPLOYEE", "MANAGER")
				.build();

		UserDetails ijkl = User.builder().username("ijkl").password("{noop}test123")
				.roles("EMPLOYEE", "MANAGER", "ADMIN").build();

		return new InMemoryUserDetailsManager(abcd, efgh, ijkl);
	}
}
