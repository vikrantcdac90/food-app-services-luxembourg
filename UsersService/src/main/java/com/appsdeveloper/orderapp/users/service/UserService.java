package com.appsdeveloper.orderapp.users.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloper.orderapp.users.dto.UserDTO;
import com.appsdeveloper.orderapp.users.entity.User;
import com.appsdeveloper.orderapp.users.mappers.UserMapper;
import com.appsdeveloper.orderapp.users.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	private BCryptPasswordEncoder passwordEncoder;

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public UserDTO addUserDetails(UserDTO userDTO) {
		passwordEncoder=new BCryptPasswordEncoder();
		User userlocal = UserMapper.MAPPER.mapToUser(userDTO);
		userlocal.setPassword(passwordEncoder.encode(userlocal.getPassword()));

		User user = userRepository.save(userlocal);
		return UserMapper.MAPPER.mapToUserDto(user);
	}

	public List<UserDTO> getAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		return users.stream().map(UserMapper.MAPPER::mapToUserDto).collect(Collectors.toList());
	}

	public Optional<UserDTO> getUserById(Long id) {
		return userRepository.findById(id).map(UserMapper.MAPPER::mapToUserDto);
	}

}
