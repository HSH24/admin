package com.hsh24.admin.stock.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.api.stock.IStockService;
import com.hsh24.admin.api.stock.bo.Stock;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.stock.dao.IStockDao;
import com.wideka.weixin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class StockServiceImpl implements IStockService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(StockServiceImpl.class);

	@Resource
	private IShopService shopService;

	@Resource
	private IStockDao stockDao;

	@Override
	public Stock getStats(Long orgId) {
		if (orgId == null) {
			return null;
		}

		Stock stock = new Stock();
		stock.setOrgId(orgId);

		try {
			return stockDao.getStats(stock);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(stock), e);
		}

		return null;
	}

	@Override
	public List<Stock> getStockList(Long orgId, Stock stock) {
		if (orgId == null || stock == null) {
			return null;
		}

		stock.setOrgId(orgId);

		List<Stock> stockList = null;

		try {
			stockList = stockDao.getStockList1(stock);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(stock), e);
		}

		if (stockList == null || stockList.size() == 0) {
			return null;
		}

		for (Stock s : stockList) {
			Shop shop = shopService.getShop(s.getShopId());
			if (shop == null) {
				continue;
			}

			s.setShopName(shop.getShopName());
		}

		return stockList;
	}

	@Override
	public List<Stock> getStockList(Long orgId, String shopId, Stock stock) {
		if (shopId == null || StringUtils.isBlank(shopId) || stock == null) {
			return null;
		}

		stock.setOrgId(orgId);
		try {
			stock.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);
		}

		try {
			return stockDao.getStockList2(stock);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(stock), e);
		}

		return null;
	}

}
