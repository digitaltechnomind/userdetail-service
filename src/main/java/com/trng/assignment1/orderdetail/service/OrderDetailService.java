package com.trng.assignment1.orderdetail.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.trng.assignment1.orderdetail.response.model.OrderLineItem;
import com.trng.assignment1.orderdetail.response.model.Orders;
import com.trng.assignment1.orderdetail.response.model.UserResponseModel;


public class OrderDetailService {
	
	
	@Autowired
	//@LoadBalanced
	protected RestTemplate restTemplate;
	
	
	protected String userserviceUrl;
	protected String orderserviceUrl;
	
	
	public OrderDetailService(String userUrl,String orderUrl) {
		this.userserviceUrl = userUrl.startsWith("http") ? userUrl
				: "http://" + userUrl;
		this.orderserviceUrl = orderUrl.startsWith("http") ? orderUrl
				: "http://" + orderUrl;
	}
	
	
	public Orders getOrder(String refid) {
		
		ResponseEntity<String> returnValue=null;
		Orders orders=null;

		try {
			
			
			orders = restTemplate.getForObject(orderserviceUrl + "/{refid}", Orders.class, refid);
			
			
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		return orders;
	}
	
	
	public UserResponseModel getUser(String refid) {
		
		UserResponseModel returnValue=null;

		try {
			
			
			returnValue = restTemplate.getForObject(userserviceUrl + "/{refid}", UserResponseModel.class,refid);
			
		} catch (HttpClientErrorException e) { // 404
			// Nothing found
		}

		return returnValue;
	}


}
