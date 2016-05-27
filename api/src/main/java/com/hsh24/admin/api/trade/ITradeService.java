package com.hsh24.admin.api.trade;

import java.math.BigDecimal;
import java.util.List;

import com.hsh24.admin.api.trade.bo.Trade;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ITradeService {

	/**
	 * 
	 * @param orgId
	 * @param type
	 * @return
	 */
	BigDecimal getTradePrice(Long orgId, String[] type);

	/**
	 * 
	 * @param orgId
	 * @param type
	 * @return
	 */
	int getTradeCount(Long orgId, String[] type);

	/**
	 * 
	 * @param orgId
	 * @param type
	 * @return
	 */
	List<Trade> getTradeList(Long orgId, String[] type);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param type
	 * @return
	 */
	List<Trade> getTradeList(Long orgId, String shopId, String[] type);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param tradeNo
	 * @return
	 */
	Trade getTrade(Long orgId, String shopId, String tradeNo);

}
