
package com.ladera.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ladera.model.Employee;
import com.ladera.model.data.EmployeeData;
import com.ladera.repository.UserRepository;
import com.ladera.request.payload.LoginRequest;
import com.ladera.request.payload.SignupRequest;
import com.ladera.response.payload.JwtResponse;
import com.ladera.response.payload.MessageResponse;
import com.ladera.security.jwt.JwtUtils;
import com.ladera.spring.security.impl.DefaultLtUserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("ladera/api/auth")
public class AuthController {

	Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils  jwtUtils;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;


	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		logger.info("Login Flow :: {}",loginRequest.getUsername());
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		DefaultLtUserDetailsImpl userDetails = (DefaultLtUserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		
		logger.info("Register Flow :: {}",signUpRequest.toString());
		if (null!=userRepository.findByEmailId(signUpRequest.getEmailId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		/*
		 * final String defaultRole = "role_user";
		 * if(CollectionUtils.isEmpty(signUpRequest.getRole())) { ArrayList<String>
		 * roles = new ArrayList<String>(); roles.add(defaultRole);
		 * signUpRequest.setRole(roles); }
		 */
		
		Employee user = new Employee(signUpRequest.getEmpId(), signUpRequest.getFirstName(), 
				signUpRequest.getLastName(),signUpRequest.getMobileNumber(),signUpRequest.getEmailId(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getRole(),null,signUpRequest.getGender());
 
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PostMapping("/userprofile/{empId}")
	public ResponseEntity<EmployeeData> getEmployeeProfile() {
		return null;
		
	}
	}
	