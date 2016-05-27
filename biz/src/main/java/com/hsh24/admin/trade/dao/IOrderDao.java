package com.hsh24.admin.trade.dao;

import java.util.List;

import com.hsh24.admin.api.trade.bo.Order;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IOrderDao {

	/**
	 * 
	 * @param order
	 * @return
	 */
	List<Order> getOrderList(Order order);

}
