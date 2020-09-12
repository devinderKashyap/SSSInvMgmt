package com.sss.im.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.sss.im.models.ImUser;
import com.sss.im.repo.ImUserRepo;

//@EnableWebSecurity
public class SecurityConfig {} /*extends WebSecurityConfigurerAdapter{

		@Autowired
		ImUserRepo userRepo;
				
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.httpBasic().and()
	        	.authorizeRequests()
	        	.antMatchers( "/", "/register", "/login","/swagger-ui.html").permitAll()
//	        	.antMatchers("/api/v1/*").authenticated()
	        	.anyRequest().authenticated()
	        	;
	        
	        http .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
	        	.and().csrf().disable()
	        	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
	    }

	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService((username) -> {
				ImUser a = userRepo.findById(username).get();
				if(a!=null) {
					return  new org.springframework.security.core.userdetails.User(a.getUserName(), a.getPassword(), true, true, true, true,
							AuthorityUtils.createAuthorityList("USER", "write"));
				}else throw new RuntimeException("could not find the user '"	+ username + "'");
			}
			).passwordEncoder(NoOpPasswordEncoder.getInstance());
	    }
}
*/