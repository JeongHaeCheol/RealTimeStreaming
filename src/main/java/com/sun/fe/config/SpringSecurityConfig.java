package com.sun.fe.config;

import java.security.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.sun.fe.service.AccountService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AccountService accountService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 허용되어야 할 경로들
		web.ignoring().antMatchers("/resources/**", "/dist/**", "/css/**", "/font-awesome/**", "/fonts/**", "/img/**",
				"/js/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/login", "/service", "/resources/**", "/create").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")

				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login") /* 내가 만든 로그인 페이지 */
				.defaultSuccessUrl("/")
				.permitAll()
				.and()
				.logout()
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(accountService);

	}

	@Bean
	public PasswordEncoder bCryptpasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
