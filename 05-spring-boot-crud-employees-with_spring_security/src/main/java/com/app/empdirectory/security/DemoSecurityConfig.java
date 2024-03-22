package com.app.empdirectory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

	// for role based authorization
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorize -> authorize.antMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
				.antMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
				.antMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
				.antMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN").anyRequest().authenticated());
		// use HTTP basic authentication
		http.httpBasic(Customizer.withDefaults());

		// disable CSRF as it is not used with stateless REST APIs, mostly
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}
}
