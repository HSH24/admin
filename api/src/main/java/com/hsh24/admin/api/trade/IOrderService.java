package com.hsh24.admin.api.trade;

import java.util.List;

import com.hsh24.admin.api.trade.bo.Order;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IOrderService {

	/**
	 * 
	 * @param shopId
	 * @param tradeId
	 * @return
	 */
	List<Order> getOrderList(Long shopId, Long tradeId);

}
