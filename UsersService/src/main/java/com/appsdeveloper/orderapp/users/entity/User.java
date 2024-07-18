package com.appsdeveloper.orderapp.users.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long userId;

	@Column(name = "firstname")
	@NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name should not exceed 100 characters")
	private String firstName;

	@Column(name = "lastname")
	@NotBlank(message = "lastname is mandatory")
    @Size(max = 100, message = "lastname should not exceed 100 characters")
	private String lastName;

	private String city;

	@Column(name = "postalcode")
	@NotBlank(message = "postalcode is mandatory")
    @Size(max = 4, message = "postalcode should not exceed 4 characters")
	private String postalCode;

	@NotBlank(message = "country is mandatory")
	private String country;

	@NotBlank(message = "street is mandatory")
    @Size(max = 100, message = "street should not exceed 100 characters")
	private String street;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "email is mandatory")
	@Email
	private String email;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "username is mandatory")
    @Size(max = 100, message = "username should not exceed 100 characters")
	private String username;
	
	@NotBlank(message = "password is mandatory")
    @Size(max = 100, message = "password should not exceed 100 characters")
	private String password;
}
