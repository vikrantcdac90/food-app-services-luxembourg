package com.appsdeveloper.orderapp.restaurants.entities;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	private String name;
	private String description;
	private BigDecimal price;
}
