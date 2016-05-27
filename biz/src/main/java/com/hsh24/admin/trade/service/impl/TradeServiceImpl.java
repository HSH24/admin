package com.hsh24.admin.trade.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.api.supplier.ISupplierService;
import com.hsh24.admin.api.supplier.bo.Supplier;
import com.hsh24.admin.api.trade.IOrderService;
import com.hsh24.admin.api.trade.ITradeService;
import com.hsh24.admin.api.trade.bo.Order;
import com.hsh24.admin.api.trade.bo.Trade;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.trade.dao.ITradeDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class TradeServiceImpl implements ITradeService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(TradeServiceImpl.class);

	private IShopService shopService;

	private ISupplierService supplierService;

	private IOrderService orderService;

	private ITradeDao tradeDao;

	@Override
	public BigDecimal getTradePrice(Long orgId, String[] type) {
		if (orgId == null) {
			return BigDecimal.ZERO;
		}

		Trade trade = new Trade();
		trade.setOrgId(orgId);
		trade.setCodes(type);

		try {
			return tradeDao.getTradePrice(trade);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(trade), e);
		}

		return BigDecimal.ZERO;
	}

	@Override
	public int getTradeCount(Long orgId, String[] type) {
		if (orgId == null) {
			return 0;
		}

		Trade trade = new Trade();
		trade.setOrgId(orgId);
		trade.setCodes(type);

		try {
			return tradeDao.getTradeCount(trade);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(trade), e);
		}

		return 0;
	}

	@Override
	public List<Trade> getTradeList(Long orgId, String[] type) {
		if (orgId == null) {
			return null;
		}

		Trade trade = new Trade();
		trade.setOrgId(orgId);
		trade.setCodes(type);

		List<Trade> tradeList = null;

		try {
			tradeList = tradeDao.getTradeList(trade);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(trade), e);
		}

		if (tradeList == null || tradeList.size() == 0) {
			return null;
		}

		for (Trade t : tradeList) {
			Shop shop = shopService.getShop(t.getShopId());
			if (shop == null) {
				continue;
			}

			t.setShopName(shop.getShopName());
		}

		return tradeList;
	}

	@Override
	public List<Trade> getTradeList(Long orgId, String shopId, String[] type) {
		if (orgId == null || shopId == null) {
			return null;
		}

		Trade trade = new Trade();
		trade.setOrgId(orgId);
		try {
			trade.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);

			return null;
		}
		trade.setCodes(type);

		List<Trade> tradeList = null;

		try {
			tradeList = tradeDao.getTradeList(trade);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(trade), e);
		}

		if (tradeList == null || tradeList.size() == 0) {
			return null;
		}

		String[] supId = new String[tradeList.size()];
		int i = 0;

		for (Trade t : tradeList) {
			supId[i++] = t.getSupId().toString();
		}

		// 获取供应商信息
		Map<Long, Supplier> map = supplierService.getSupplier(supId);

		for (Trade t : tradeList) {
			Supplier supplier = map.get(t.getSupId());
			if (supplier != null) {
				t.setSupName(supplier.getSupName());
			}

			t.setOrderList(orderService.getOrderList(trade.getShopId(), t.getTradeId()));
		}

		return tradeList;
	}

	@Override
	public Trade getTrade(Long orgId, String shopId, String tradeNo) {
		if (orgId == null || StringUtils.isBlank(shopId) || StringUtils.isBlank(tradeNo)) {
			return null;
		}

		Trade t = new Trade();
		t.setOrgId(orgId);
		try {
			t.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);

			return null;
		}
		t.setTradeNo(tradeNo.trim());

		Trade trade = null;

		try {
			trade = tradeDao.getTrade(trade);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(trade), e);
		}

		if (trade == null) {
			return null;
		}

		Supplier supplier = supplierService.getSupplier(trade.getSupId());

		if (supplier != null) {
			trade.setSupName(supplier.getSupName());
		}

		List<Order> orderList = orderService.getOrderList(trade.getShopId(), trade.getTradeId());

		if (orderList != null && orderList.size() > 0) {
			trade.setOrderList(orderList);
		}

		return trade;
	}

	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public ISupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
	}

	public ITradeDao getTradeDao() {
		return tradeDao;
	}

	public void setTradeDao(ITradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

}
