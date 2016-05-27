package com.hsh24.admin.trade.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.hsh24.admin.api.trade.bo.Trade;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.trade.dao.ITradeDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class TradeDaoImpl extends BaseDaoImpl implements ITradeDao {

	@Override
	public BigDecimal getTradePrice(Trade trade) {
		return (BigDecimal) getSqlMapClientTemplate().queryForObject("trade.getTradePrice", trade);
	}

	@Override
	public int getTradeCount(Trade trade) {
		return (Integer) getSqlMapClientTemplate().queryForObject("trade.getTradeCount", trade);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Trade> getTradeList(Trade trade) {
		if (trade.getShopId() == null) {
			return (List<Trade>) getSqlMapClientTemplate().queryForList("trade.getTradeList1", trade);
		} else {
			return (List<Trade>) getSqlMapClientTemplate().queryForList("trade.getTradeList2", trade);
		}
	}

}
