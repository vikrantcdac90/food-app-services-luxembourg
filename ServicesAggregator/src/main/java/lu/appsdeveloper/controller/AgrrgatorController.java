package lu.appsdeveloper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.appsdeveloper.orderapp.restaurants.entities.Restaurant;
import com.appsdeveloper.orderapp.users.dto.AuthenticationDTO;
import com.appsdeveloper.orderapp.users.exceptions.UserNotFoundException;
import com.appsdeveloper.orderapp.users.response.ApiResponse;

import lu.appsdeveloper.entities.Cart;
import lu.appsdeveloper.entities.CartItem;
import lu.appsdeveloper.httpclient.RestaurantServiceClient;
import lu.appsdeveloper.httpclient.UserServiceClient;

@RestController
@RequestMapping("/aggregator")
public class AgrrgatorController {

	@Autowired
	private UserServiceClient userServiceClient;

	@Autowired
	private RestaurantServiceClient restaurantServiceClient;

	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants(@RequestBody AuthenticationDTO userId) {
		// Verify user login status
		ApiResponse<String> userLoginResponse = userServiceClient.getUserById(userId);
		if (!userLoginResponse.isSuccess()) {
			throw new UserNotFoundException("User not found");
		}

		// Fetch all restaurants with menus
		return restaurantServiceClient.getAllRestaurants();
	}

	@PostMapping("/cart")
	public Cart addToCart(@RequestBody AuthenticationDTO userId, @RequestBody CartItem cartItem) {
		// Verify user login status User
		ApiResponse<String> userLoginResponse = userServiceClient.getUserById(userId);
		if (!userLoginResponse.isSuccess()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
		}

		// Add item to cart return cartService.addToCart(userId, cartItem);

		return null;
	}

}
