package com.hsh24.admin.stock.dao.impl;

import java.util.List;

import com.hsh24.admin.api.stock.bo.Stock;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.stock.dao.IStockDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class StockDaoImpl extends BaseDaoImpl implements IStockDao {

	@Override
	public Stock getStats(Stock stock) {
		return (Stock) getSqlMapClientTemplate().queryForObject("stock.getStats", stock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Stock> getStockList(Stock stock) {
		if (stock.getShopId() == null) {
			return (List<Stock>) getSqlMapClientTemplate().queryForList("stock.getStockList1", stock);
		} else {
			return (List<Stock>) getSqlMapClientTemplate().queryForList("stock.getStockList2", stock);
		}
	}

}
