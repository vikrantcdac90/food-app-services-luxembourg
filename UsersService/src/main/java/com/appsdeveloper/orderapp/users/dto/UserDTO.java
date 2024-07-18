package com.appsdeveloper.orderapp.users.dto;

public record UserDTO(Long userId, String firstName, String lastName, String city, String postalCode, String country,
		String street,String email,String username,String password) {

}
