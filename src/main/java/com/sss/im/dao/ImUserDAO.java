package com.sss.im.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sss.im.exceptions.UserNotFoundException;
import com.sss.im.models.ImUser;
import com.sss.im.repo.ImUserRepo;

@Service
public class ImUserDAO {
	
	@Autowired
	ImUserRepo repo;
	
	
	public ImUser registerUser(ImUser user) {
		return repo.save(user);
	}

	public ImUser getUser(String userName) {
		Optional<ImUser> temp = repo.findById(userName);
		if(temp.isPresent()) {
			return temp.get();
		}
		throw new UserNotFoundException(userName);
	}
	
	public void deleteUser(String userName) {
		Optional<ImUser> temp = repo.findById(userName);
		if(temp.isPresent()) {
			repo.deleteById(userName);
			return;
		}
		throw new UserNotFoundException(userName);
	}

	public ImUser updateUser(String userName, ImUser user) {
		Optional<ImUser> temp = repo.findById(userName);
		if(temp.isPresent()) {
			user.setUserName(userName);
			return repo.save(user);
		}
		throw new UserNotFoundException(userName);
	}

	public List<ImUser> getAllUser() {
		List<ImUser> users = new ArrayList<>();
		repo.findAll().forEach(users::add);
		return users;
	}
}
