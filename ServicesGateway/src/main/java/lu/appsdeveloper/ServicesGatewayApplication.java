package lu.appsdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServicesGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesGatewayApplication.class, args);
	}

}
