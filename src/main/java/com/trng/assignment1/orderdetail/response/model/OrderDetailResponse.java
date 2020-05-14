package com.trng.assignment1.orderdetail.response.model;

import java.util.ArrayList;



public class OrderDetailResponse {
	
	
	private UserResponseModel userDetails;
	private ArrayList<OrderLineItem> orders;

	public ArrayList<OrderLineItem> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<OrderLineItem> orders) {
		this.orders = orders;
	}
	public UserResponseModel getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserResponseModel userDetails) {
		this.userDetails = userDetails;
	}
	
	
	

}
