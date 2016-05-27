package com.hsh24.admin.api.stock;

import java.util.List;

import com.hsh24.admin.api.stock.bo.Stock;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IStockService {

	/**
	 * 
	 * @param orgId
	 * @return
	 */
	Stock getStats(Long orgId);

	/**
	 * 
	 * @param orgId
	 * @param stock
	 * @return
	 */
	List<Stock> getStockList(Long orgId, Stock stock);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param stock
	 * @return
	 */
	List<Stock> getStockList(Long orgId, String shopId, Stock stock);

}
