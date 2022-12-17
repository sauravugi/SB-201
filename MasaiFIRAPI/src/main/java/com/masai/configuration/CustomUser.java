package com.masai.configuration;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.model.User;
import com.masai.repository.UserDao;

@Service
public class CustomUser implements UserDetailsService{
	
	@Autowired
	private UserDao uRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = uRepo.findByMobile(username);
		
		if(user.isEmpty()) throw new UsernameNotFoundException("User Does not exist");
		
		return new SecurityUser(user.get());
	}

}
