package com.glinboy.jpress.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	public static final String[] AUTH_WHITELIST = {
			"/",
			"/**"
	};
	
	public static final String[] IGNORE_WHITELIST = {
			"/resources/**",
			"/static/**",
			"/css/**",
			"/js/**",
			"/images/**",
			"/img/**",
			"/webjars/**",
			"/h2-console/**"
	};

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) {
		http
			.csrf(csrf -> csrf
				.ignoringRequestMatchers(IGNORE_WHITELIST)
			)
			.headers(headers -> headers
				.frameOptions(FrameOptionsConfig::sameOrigin)
			)
			.authorizeHttpRequests(requests -> requests
				.requestMatchers("/admin/**").authenticated()
				.requestMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin(form -> form
				.loginPage("/login")
				.usernameParameter("user_name")
				.passwordParameter("password")
				.successForwardUrl("/admin")
				.failureUrl("/login?error=true")
				.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
			);
		return http.build();
	}
}
