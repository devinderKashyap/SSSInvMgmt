package com.sss.im.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sss.im.dao.ImUserDAO;
import com.sss.im.models.ImUser;

@RestController
@RequestMapping("${api.v1.baseurl}/users")
public class ImUserController {
	
	@Autowired
	ImUserDAO dao;

	
	/*@RequestMapping(method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ImUser registerUser(@RequestBody ImUser user) {
		return dao.registerUser(user);
	}*/
	
	@RequestMapping(value="/{userName}")
	public ImUser getUser(@PathVariable String userName) {
		return dao.getUser(userName);
	}

	@RequestMapping(value="/{userName}",method=RequestMethod.DELETE)
	public void deleteUserById(@PathVariable String userName) {
		System.out.println("UsersController.deleteUser()"+userName);
		dao.deleteUser(userName);
	}
	
	@RequestMapping(value="/{userName}",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.PUT)
	public ImUser updateUser(@PathVariable String userName,@RequestBody ImUser user) {
		return dao.updateUser(userName,user);
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<ImUser> getAllUsers(){
		return dao.getAllUser();
	}

}
