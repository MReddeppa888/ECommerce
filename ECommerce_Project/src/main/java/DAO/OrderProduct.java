package DAO;

import java.util.ArrayList;

import Models.Order;


public interface OrderProduct 
{
	
	 int addOrderItem(Order o);
	 ArrayList<Order> getAllOrderItem();
	 ArrayList<Order> getOrderItem(int orderItemId);
	 int deleteOrderItem(int orderItemId);
	 int updateOrderItem(Order o);
	
	 
}