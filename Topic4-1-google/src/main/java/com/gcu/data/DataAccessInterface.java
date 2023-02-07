package com.gcu.data;

import java.util.List;

// <T> where T is just a placeholder for the model (parameter data type)
// t is the placeholder for the parameter name
public interface DataAccessInterface <T>
{
	/**
	 * 
	 * @return
	 */
	public List<T> findAll(); 
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public T findById(int id);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean create(T t);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t); 
}
