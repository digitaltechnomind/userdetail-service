package com.trng.assignment1;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.trng.assignment1.orderdetail.service.OrderDetailService;

@SpringBootApplication
public class OrderdetailServiceApplication {
	
	private static String ORDER_URL="http://localhost:8091/order";
	private static String USER_URL="http://localhost:8090/user";;

	public static void main(String[] args) {
		SpringApplication.run(OrderdetailServiceApplication.class, args);
	}
	
	//@LoadBalanced    // Make sure to create the load-balanced template
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	
	@Bean
    public OrderDetailService createService() {
        return new OrderDetailService(USER_URL,ORDER_URL);
    }

}
