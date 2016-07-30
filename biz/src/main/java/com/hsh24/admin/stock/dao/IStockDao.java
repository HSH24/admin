package com.hsh24.admin.stock.dao;

import java.util.List;

import com.hsh24.admin.api.stock.bo.Stock;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IStockDao {

	/**
	 * 
	 * @param stock
	 * @return
	 */
	Stock getStats(Stock stock);

	/**
	 * 
	 * @param stock
	 * @return
	 */
	List<Stock> getStockList1(Stock stock);

	/**
	 * 
	 * @param stock
	 * @return
	 */
	List<Stock> getStockList2(Stock stock);

}
