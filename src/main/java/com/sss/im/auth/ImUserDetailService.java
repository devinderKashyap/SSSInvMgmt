package com.sss.im.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sss.im.models.ImUser;
import com.sss.im.repo.ImUserRepo;

@Service
public class ImUserDetailService implements UserDetailsService{

	@Autowired
	ImUserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ImUser a = userRepo.findById(username).get();
		if(a!=null) {
			return  new org.springframework.security.core.userdetails.User(a.getUserName(), a.getPassword(), true, true, true, true,
					AuthorityUtils.createAuthorityList("USER", "write"));
		}else throw new UsernameNotFoundException("Could not find the user '"	+ username + "'");
	
	}

}
