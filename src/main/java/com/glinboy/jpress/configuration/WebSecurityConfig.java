package com.glinboy.jpress.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.glinboy.jpress.service.UserServiceApi;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private final UserServiceApi userServiceApi;

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
//		http
//			.authorizeRequests()
//			.antMatchers("/admin/**").authenticated()
//			.antMatchers("/**").permitAll()
//			.and().csrf().disable().formLogin()
//			.loginPage("/login").failureUrl("/login?error=true")
//			.defaultSuccessUrl("/admin")
//			.usernameParameter("user_name")
//			.passwordParameter("password")
//			.and().logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").and().exceptionHandling()
//			.accessDeniedPage("/access-denied");
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/admin/**").authenticated()
				.requestMatchers("/**").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/login")
				.usernameParameter("user_name")
				.passwordParameter("password")
				.successForwardUrl("/admin")
				.failureUrl("/login?error=true")
				.permitAll()
			)
			.logout((logout) -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.permitAll()
			);
		return http.build();
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers("/resources/**", "/static/**", "/css/**",
				"/js/**", "/images/**", "/img/**", "/webjars/**", "/h2-console/**");
	}
}
