package com.app.empdirectory.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	// we are commenting out the below code as it is hard coding the values
	// instead we will be suing our database to find the roles of the user and then
	// dealing with them accordingly

	/*
	 * @Bean public InMemoryUserDetailsManager userDetaisManager() { UserDetails
	 * abcd =
	 * User.builder().username("abcd").password("{noop}test123").roles("EMPLOYEE").
	 * build();
	 * 
	 * UserDetails efgh =
	 * User.builder().username("efgh").password("{noop}test123").roles("EMPLOYEE",
	 * "MANAGER") .build();
	 * 
	 * UserDetails ijkl = User.builder().username("ijkl").password("{noop}test123")
	 * .roles("EMPLOYEE", "MANAGER", "ADMIN").build();
	 * 
	 * return new InMemoryUserDetailsManager(abcd, efgh, ijkl); }
	 */

	// add support for JDBC .... no more hard coded users
	@Bean
	public UserDetailsManager userDetailsManager(DataSource dataSource) {

		return new JdbcUserDetailsManager(dataSource);

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
