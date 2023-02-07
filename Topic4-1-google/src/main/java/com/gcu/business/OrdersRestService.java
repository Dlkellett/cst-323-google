package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.OrderModel;

/*
 * @RestController is a convenience annotation for creating Restful controllers. It adds the @Controller and @ResponseBody 
 * annotations. It converts the response to JASON or XML.
 */
@RestController
/*
 * @RequestMapping() is the most commonly/widely used annotation in Spring MVC, it is used to map requests into 
 * specific handler classes and/or handler methods.
 */
@RequestMapping("/service")
public class OrdersRestService 
{
	/* 
	 * Inject this bean into the OrdersRestService bean using @Autowired on the field definition.
	 */
	@Autowired 
	//OrdersBusinessService service;
	OrdersBusinessServiceInterface service;
	
	/* 
	 * The @GetMapping() annotation is the specialized version of @RequestMapping() annotations.
	 * It acts as a shortcut for @RequestMapping(). The @GetMapping() method is the @Controller annotated
	 * classes, handle the HTTP GET request. The produces = MediaType.APPLICATION_JSON_VALUE means that 
	 * the response that will be produced will be converted into JSON format.
	 */
	@GetMapping(path="/getJSON", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<OrderModel> getOrdersAsJson()
	{
		return service.getOrders();
	}
	
	@GetMapping(path="/getXml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml()
	{
		OrderList list = new OrderList();
		list.setOrders(service.getOrders());
		return list;
	}
}
