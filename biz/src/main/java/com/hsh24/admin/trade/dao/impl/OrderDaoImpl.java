package com.hsh24.admin.trade.dao.impl;

import java.util.List;

import com.hsh24.admin.api.trade.bo.Order;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.trade.dao.IOrderDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class OrderDaoImpl extends BaseDaoImpl implements IOrderDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrderList(Order order) {
		return (List<Order>) getSqlMapClientTemplate().queryForList("trade.order.getOrderList", order);
	}

}
