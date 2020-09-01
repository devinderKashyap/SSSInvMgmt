package com.sss.im.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.auth.AuthResponse;
import com.sss.im.auth.ImUserDetailService;
import com.sss.im.auth.JWTUtil;
import com.sss.im.dao.ImUserDAO;
import com.sss.im.models.ImUser;

@RestController
@RequestMapping("")
public class LoginController {
	
	@Autowired
	ImUserDAO dao;

	@Autowired
	AuthenticationManager authMngr;
	
	@Autowired
	ImUserDetailService userDetailService;
	
	@Autowired
	JWTUtil jwtUtil;
	
	@RequestMapping(value="/register",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ImUser registerUser(@RequestBody ImUser user) {
		return dao.registerUser(user);
	}
	
	@RequestMapping(value="/authenticate",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AuthResponse> createJWT(@RequestBody ImUser user) {
		try {
			authMngr.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		} catch (Exception e) {
			throw new RuntimeException("Invalid UserName/ Password");
		}
		
		String jwt = jwtUtil.generateToken(userDetailService.loadUserByUsername(user.getUserName()));
		return ResponseEntity.ok(new AuthResponse(jwt));
	}
	

}
