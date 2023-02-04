package com.ladera.spring.security.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ladera.model.Employee;
import com.ladera.repository.UserRepository;

@Service
public class DefaultLtUserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
      
		Employee user = userRepository.findByEmailId(emailId);
       if(Objects.isNull(user)) {
        	throw new UsernameNotFoundException("User Not Found with emailId: " + emailId);
		}
		return DefaultLtUserDetailsImpl.build(user);
	}

}
