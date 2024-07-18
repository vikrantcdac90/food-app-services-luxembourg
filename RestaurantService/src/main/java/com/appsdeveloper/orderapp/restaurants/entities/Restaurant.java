package com.appsdeveloper.orderapp.restaurants.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "restaurants")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	@Id
	private String id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private List<MenuItem> menuItems;

}
