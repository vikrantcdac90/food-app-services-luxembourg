package com.appsdeveloper.orderapp.users.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.appsdeveloper.orderapp.users.entity.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
	User findByUsername(String username);

}
