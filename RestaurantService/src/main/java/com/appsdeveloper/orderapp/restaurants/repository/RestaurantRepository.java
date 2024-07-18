package com.appsdeveloper.orderapp.restaurants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.appsdeveloper.orderapp.restaurants.entities.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
}
