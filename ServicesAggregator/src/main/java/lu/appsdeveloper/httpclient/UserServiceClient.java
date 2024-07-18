package lu.appsdeveloper.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.appsdeveloper.orderapp.users.dto.AuthenticationDTO;
import com.appsdeveloper.orderapp.users.response.ApiResponse;

@FeignClient(name = "users-service")
public interface UserServiceClient {
    @GetMapping("/users/login")
    ApiResponse<String> getUserById(@RequestBody AuthenticationDTO dto);
}