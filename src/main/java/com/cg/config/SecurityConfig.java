package com.cg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cg.security.JwtAuthFilter;

@Configuration
public class SecurityConfig {

	@Autowired
	private JwtAuthFilter jwtAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/generateToken", "/viewall").permitAll())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/swagger-ui.html").permitAll())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/swagger-ui/**", "/swagger-resources/*", "/v3/api-docs/**").permitAll())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/search").authenticated())
				.authorizeHttpRequests(auth -> auth.requestMatchers("/addcart", "/editcart").hasRole("USER"))
				.authorizeHttpRequests(auth -> auth.requestMatchers("/addproduct").hasRole("ADMIN"))
				.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class).build();
	}
}
