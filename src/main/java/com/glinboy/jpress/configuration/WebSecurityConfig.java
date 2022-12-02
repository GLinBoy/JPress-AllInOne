package com.glinboy.jpress.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.glinboy.jpress.service.UserServiceApi;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private final UserServiceApi userServiceApi;
	
	private static final String[] AUTH_WHITELIST = {
			"/",
			"/**"
	};
	
	private static final String[] IGNORE_WHITELIST = {
			"/resources/**",
			"/static/**",
			"/css/**",
			"/js/**",
			"/images/**",
			"/img/**",
			"/webjars/**",
			"/h2-console/**"
	};

	public WebSecurityConfig(UserServiceApi userServiceApi) {
		this.userServiceApi = userServiceApi;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.csrf().ignoringRequestMatchers(IGNORE_WHITELIST).disable()
			.headers().frameOptions().sameOrigin()
			.and()
			.authorizeHttpRequests( requests -> requests
				.requestMatchers("/admin/**").authenticated()
				.requestMatchers(AUTH_WHITELIST).permitAll()
				.anyRequest().authenticated()
			)
			.formLogin( form -> form
				.loginPage("/login")
				.usernameParameter("user_name")
				.passwordParameter("password")
				.successForwardUrl("/admin")
				.failureUrl("/login?error=true")
				.permitAll()
			)
			.logout( logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
			);
		return http.build();
	}
}
