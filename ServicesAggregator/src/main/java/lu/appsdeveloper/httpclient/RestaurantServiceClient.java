package lu.appsdeveloper.httpclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.appsdeveloper.orderapp.restaurants.entities.Restaurant;

@FeignClient(name = "restaurantservice")
public interface RestaurantServiceClient {
    @GetMapping("/api/restaurants")
    List<Restaurant> getAllRestaurants();
}