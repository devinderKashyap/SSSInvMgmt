package com.sss.im.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter{

		@Autowired
		ImUserDetailService userDetailService;
		
		@Autowired
		JWTRequestFilter jwtFilter;
				
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        	.authorizeRequests()
//	        	.antMatchers( "/webjars/springfox-swagger-ui/**").permitAll()
//	        	.antMatchers( "/swagger-ui.html").permitAll()
//	        	.antMatchers( "/register").permitAll()
//	        	.antMatchers( "/authenticate").permitAll()
//	        	.antMatchers( "/", "/register", "/login","/swagger-ui.html").permitAll()
	        	.antMatchers("/api/**").authenticated()
//	        	.anyRequest().authenticated()
	        	;
	        
	        http .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        	.and()
	        	.csrf().disable()
	        	/*.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())*/;
	        
	        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailService)
			 .passwordEncoder(NoOpPasswordEncoder.getInstance());
	    }
	    
	    @Override
		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}
}
