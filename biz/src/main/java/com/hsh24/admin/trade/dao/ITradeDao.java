package com.hsh24.admin.trade.dao;

import java.math.BigDecimal;
import java.util.List;

import com.hsh24.admin.api.trade.bo.Trade;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ITradeDao {

	/**
	 * 
	 * @param trade
	 * @return
	 */
	BigDecimal getTradePrice(Trade trade);

	/**
	 * 
	 * @param trade
	 * @return
	 */
	int getTradeCount(Trade trade);

	/**
	 * 
	 * @param trade
	 * @return
	 */
	List<Trade> getTradeList(Trade trade);

}
