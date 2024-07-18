package com.appsdeveloper.orderapp.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloper.orderapp.restaurants.entities.MenuItem;
import com.appsdeveloper.orderapp.restaurants.entities.Restaurant;
import com.appsdeveloper.orderapp.restaurants.repository.MenuItemRepository;
import com.appsdeveloper.orderapp.restaurants.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private MenuItemRepository menuItemRepository;

	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public List<Restaurant> createRestaurants(List<Restaurant> restaurants) {
		return restaurantRepository.saveAll(restaurants);
	}

	public MenuItem createMenuItem(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}

	public List<MenuItem> createMenuItems(List<MenuItem> menuItem) {
		return menuItemRepository.saveAll(menuItem);
	}

	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Restaurant getRestaurantById(String id) {
		return restaurantRepository.findById(id).orElse(null);

	}

	public void addMenuItemToRestaurant(String restaurantId, MenuItem menuItem) {
		Restaurant restaurant = getRestaurantById(restaurantId);
		if (restaurant != null) {
			restaurant.getMenuItems().add(menuItem);
			restaurantRepository.save(restaurant);
		}
	}

	public Restaurant addMenuItemsToRestaurant(String restaurantId, List<MenuItem> menuItems) {
		//List<MenuItem> allmenuItems = menuItemRepository.saveAll(menuItems);
		Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
		if (restaurant != null) {
			restaurant.getMenuItems().addAll(menuItems);
			return restaurantRepository.save(restaurant);
		}
		return null;
	}

}
