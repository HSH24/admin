package com.hsh24.admin.trade.service.impl;

import java.util.List;

import com.hsh24.admin.api.trade.IOrderService;
import com.hsh24.admin.api.trade.bo.Order;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.trade.dao.IOrderDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class OrderServiceImpl implements IOrderService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(OrderServiceImpl.class);

	private IOrderDao orderDao;

	@Override
	public List<Order> getOrderList(Long shopId, Long tradeId) {
		if (shopId == null || tradeId == null) {
			return null;
		}

		Order order = new Order();
		order.setTradeId(tradeId);

		List<Order> orderList = null;

		try {
			orderList = orderDao.getOrderList(order);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(order), e);

			return null;
		}

		if (orderList == null || orderList.size() == 0) {
			return null;
		}

		return orderList;
	}

	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
