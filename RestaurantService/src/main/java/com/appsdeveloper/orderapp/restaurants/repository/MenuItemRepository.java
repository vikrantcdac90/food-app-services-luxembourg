package com.appsdeveloper.orderapp.restaurants.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.appsdeveloper.orderapp.restaurants.entities.MenuItem;

public interface MenuItemRepository extends MongoRepository<MenuItem, String> {
}
