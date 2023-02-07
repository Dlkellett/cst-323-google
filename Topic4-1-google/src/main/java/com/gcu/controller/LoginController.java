package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	// Dependency Injection 
	// We can use autowiring on properties, setters, and constructors.
	// Using "autowired" on a property it will eliminate the need for getters and setters.
	// When autowiring a property in bean, the property's class type is used
	// for searching a matching bean definition in the configuration file. If
	// a bean is found it is injected into the property. 
	// In this case we are autowiring to SpringConfig getOrdersBusiness method.
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private SecurityBusinessService security;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display login form view 
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		// Check for validation errors 
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Make a call to the Security Business Service 
		security.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		// Make a call to the Orders Business Service 
		service.test();
		 
		// Display the Orders View
		model.addAttribute("title", "My Orders");
		model.addAttribute("orders", service.getOrders());
		return "orders";
	}
}
