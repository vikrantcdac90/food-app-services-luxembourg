package com.appsdeveloper.orderapp.restaurants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.appsdeveloper.orderapp.restaurants.entities.MenuItem;
import com.appsdeveloper.orderapp.restaurants.entities.Restaurant;
import com.appsdeveloper.orderapp.restaurants.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }
    
    @PostMapping("/bulk")
    public List<Restaurant> createRestaurants(@RequestBody List<Restaurant> restaurants) {
        return restaurantService.createRestaurants(restaurants);
    }

    @PostMapping("/{restaurantId}/menu-items")
    public MenuItem addMenuItemToRestaurant(@PathVariable String restaurantId, @RequestBody MenuItem menuItem) {
        //MenuItem createdMenuItem = restaurantService.createMenuItem(menuItem);
        restaurantService.addMenuItemToRestaurant(restaurantId, menuItem);
        return menuItem;
    }
    
    @PostMapping("/{restaurantId}/menu-items/bulk")
    public Restaurant addMenuItemsToRestaurant(@PathVariable String restaurantId, @RequestBody List<MenuItem> menuItems) {
    	//List<MenuItem> createdMenuItems = restaurantService.createMenuItems(menuItems);
        return restaurantService.addMenuItemsToRestaurant(restaurantId, menuItems);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }
}
