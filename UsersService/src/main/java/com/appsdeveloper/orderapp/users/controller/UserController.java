package com.appsdeveloper.orderapp.users.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloper.orderapp.users.dto.AuthenticationDTO;
import com.appsdeveloper.orderapp.users.dto.UserDTO;
import com.appsdeveloper.orderapp.users.exceptions.UserNotFoundException;
import com.appsdeveloper.orderapp.users.response.ApiResponse;
import com.appsdeveloper.orderapp.users.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping(path = "/addUser")
	public ResponseEntity<ApiResponse<UserDTO>> getMessage(@Valid @RequestBody UserDTO userDTO) {

		if (userService.findByUsername(userDTO.username()) != null) {
			throw new UserNotFoundException("user does not exist");
		}
		ApiResponse<UserDTO> response = new ApiResponse<>();

		response.setData(userService.addUserDetails(userDTO));
		response.setMessage("user has been created.");
		response.setSuccess(true);
		response.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<>(response, HttpStatus.CREATED);

	}

	@GetMapping(path = "/getAllUsers")
	public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
		List<UserDTO> users = new ArrayList<>();
		ApiResponse<List<UserDTO>> response = new ApiResponse<>();
		userService.getAllUsers().forEach(users::add);

		response.setData(users);
		response.setSuccess(true);
		response.setCode(HttpStatus.OK.value());

		if (users.isEmpty()) {
			response.setMessage("no records found.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		response.setMessage("list of users found.");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping(path = "/getUserById/{userid}")
	public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable(name = "userid") Long userId) {
		ApiResponse<UserDTO> response = new ApiResponse<>();
		Optional<UserDTO> userById = userService.getUserById(userId);

		userById.ifPresentOrElse((userdto) -> {
			response.setMessage("records found.");
			response.setData(userdto);
			response.setSuccess(true);
			response.setCode(HttpStatus.OK.value());
		}, () -> new UserNotFoundException("user not found " + userId));

		return new ResponseEntity<ApiResponse<UserDTO>>(response, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<String>> loginUser(@Valid @RequestBody AuthenticationDTO user) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));

		ApiResponse<String> response = new ApiResponse<>();

		authentication.isAuthenticated();

		response.setMessage("authentication processed");
		response.setSuccess(authentication.isAuthenticated());
		response.setCode(HttpStatus.OK.value());

		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<ApiResponse<String>>(response, HttpStatus.OK);
	}

}
