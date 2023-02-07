package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.model.OrderModel;

/*
 * Spring Bean implementation class OrderDataService
 */
// Annotates classes at the service layer
@Service
public class OrdersDataService implements DataAccessInterface<OrderModel>
{
	/*
	 * The DataSource interface provides the JavaBean Framework with an abstraction of an 
	 * arbitrary collection o data. It provides a type that data will access to it in the
	 * form of an InputStreams and OutPutSteams.
	 */
	@Autowired
	private DataSource dataSource;
	/*
	 * Spring JdbcTemplate is a powerful mechanism to connect to the database and execute
	 * SQL queries. It internally uses the JDBC api. 
	 */
	private JdbcTemplate jdbcTemplateObject;
	/*
	 * Autowiring feature of spring framework enables you to inject an object dependency implicitly.
	 * It internally uses setters and getters or constructor injection. Autowiring can't be used to inject 
	 * primitive and string values.
	 */
	
	/*
	 * Non-Default constructor (Parameterized Constructor) 
	 */
	public OrdersDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	/**
	 * CRUD: Finder to return all entities 
	 */
	public List<OrderModel> findAll()
	{
		String sql = "SELECT * FROM cst339.order";
		List<OrderModel> order = new ArrayList<OrderModel>();
		try
		{
			//Execute SQL Query and loop over result set
			SqlRowSet srs = jdbcTemplateObject.queryForRowSet(sql);		
			while(srs.next())
			{
				order.add(new OrderModel(srs.getLong("id"), srs.getString("order_no"), srs.getString("product_name"), srs.getFloat("price"), srs.getInt("quantity")));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return order;
	}
	
	/**
	 * CRUD: Finder to create an entity
	 */
	public boolean create(OrderModel order)
	{
		String sql = "INSERT INTO orders(order_no, product_name, price, quantity) VALUES(?, ?, ?, ?)";
		try
		{
			// Execute SQL Insert 
			int rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
			
			// Return the result of Insert
			return rows == 1 ? true : false;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * CRUD: Update an entity
	 */
	public boolean update(OrderModel order)
	{
		return true;
	}
	
	/**
	 * CRUD: Delete an entity
	 */
	public boolean delete(OrderModel order)
	{
		return true;
	}

	@Override
	public OrderModel findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}















