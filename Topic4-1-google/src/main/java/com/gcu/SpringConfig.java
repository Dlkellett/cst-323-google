package com.gcu;

//Preconceived imports
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

//Custom imports 
import com.gcu.business.AnotherOrdersBusinessService;
import com.gcu.business.OrdersBusinessService;
import com.gcu.business.OrdersBusinessServiceInterface;

// The Spring Framework enables automatic dependency injection.
// In other words, by declaring all the bean dependencies in 
// a Spring configuration file, Spring container can autowire 
// relationships between collaborating beans.
@Configuration 
public class SpringConfig
{
	// Bean annotation is applied at the method level 
	@Bean(name="ordersBusinessService", initMethod="init", destroyMethod="destroy")
	// @Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
	// RequestScope - All Instances are handled independently and have no effect on each other.
	// So the RequestScope can be especially useful for components whose properties are set by a form.
	// @RequestScope 
	// Scoping the bean to a session is a handy way to store state relevant to a specified 
	// user session. You end up with one instance per session. 
	// @SessionScope
	public OrdersBusinessServiceInterface getOrdersBusiness()
	{
		// Returns defines which java class is invoked 
		// that implements the OrdersBusinessServiceInterface
		return new OrdersBusinessService();
	}
}