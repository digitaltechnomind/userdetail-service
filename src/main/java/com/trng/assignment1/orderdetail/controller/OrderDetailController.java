package com.trng.assignment1.orderdetail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trng.assignment1.orderdetail.response.model.OrderDetailResponse;
import com.trng.assignment1.orderdetail.response.model.Orders;
import com.trng.assignment1.orderdetail.response.model.UserResponseModel;
import com.trng.assignment1.orderdetail.service.OrderDetailService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {
	
	
	@Autowired
	OrderDetailService orderService;
	
	
	
	@RequestMapping("/{refNumber}")
	public OrderDetailResponse byNumber(@PathVariable("refNumber") String refNumber) {

		
		OrderDetailResponse orderdeatilresp=new OrderDetailResponse();
		UserResponseModel userResponse=orderService.getUser(refNumber);
		Orders orderResponse=orderService.getOrder(refNumber);
		orderdeatilresp.setUserDetails(userResponse);
		orderdeatilresp.setOrders(orderResponse.getOrders());

		
		
		return orderdeatilresp;
	}

}
