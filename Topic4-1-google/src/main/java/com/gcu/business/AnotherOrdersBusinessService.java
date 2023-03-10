package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.OrderModel;

// For comments look at the "orderBusindessService.java" file
public class AnotherOrdersBusinessService implements OrdersBusinessServiceInterface
{
	public void init()
	{
		System.out.println("In the AnotherOrderBusinessService.init()");
	}
	
	public void destroy()
	{
		System.out.println("In the AnotherOrderBusinessService.destroy()");
	}
	
	public void test()
	{
		System.out.println("Hello from the AnotherOrdersBusinessService!");
	}
	
	public List<OrderModel> getOrders() 
	{
		// Create some orders
		List<OrderModel> orders = new ArrayList<OrderModel>();
		orders.add(new OrderModel(0L, "0000000001", "Product 1", 1.00f, 1));
		orders.add(new OrderModel(1L, "0000000002", "Product 2", 2.00f, 2));
		orders.add(new OrderModel(2L, "0000000003", "Product 3", 3.00f, 3));
		orders.add(new OrderModel(3L, "0000000004", "Product 4", 4.00f, 4));
		orders.add(new OrderModel(4L, "0000000005", "Product 5", 5.00f, 5));
		
		// Return the list of orders 
		return orders;
	}
}
