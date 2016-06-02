package com.hsh24.admin.cashflow.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hsh24.admin.api.cashflow.ICashflowService;
import com.hsh24.admin.api.cashflow.bo.Cashflow;
import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.cashflow.dao.ICashflowDao;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class CashflowServiceImpl implements ICashflowService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(CashflowServiceImpl.class);

	private IShopService shopService;

	private ICashflowDao cashflowDao;

	@Override
	public Cashflow getCashflowStats(Long orgId, String code) {
		return getCashflowStats(orgId, null, code);
	}

	@Override
	public Cashflow getCashflowStats(Long orgId, String shopId, String code) {
		if (orgId == null) {
			return null;
		}

		Cashflow cashflow = new Cashflow();
		cashflow.setOrgId(orgId);
		if (StringUtils.isNotBlank(shopId)) {
			try {
				cashflow.setShopId(Long.parseLong(shopId));
			} catch (NumberFormatException e) {
				logger.error(e);

				return null;
			}
		}
		cashflow.setCode(code);

		try {
			return cashflowDao.getCashflowStats(cashflow);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(cashflow), e);
		}

		return null;
	}

	@Override
	public List<Cashflow> getCashflowStats(Long orgId, Cashflow cashflow) {
		if (orgId == null || cashflow == null) {
			return null;
		}

		cashflow.setOrgId(orgId);

		List<Cashflow> cashflowList = null;

		try {
			cashflowList = cashflowDao.getCashflowList(cashflow);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(cashflow), e);
		}

		if (cashflowList == null || cashflowList.size() == 0) {
			return null;
		}

		for (Cashflow c : cashflowList) {
			Shop shop = shopService.getShop(c.getShopId());
			if (shop == null) {
				continue;
			}

			c.setShopName(shop.getShopName());
		}

		return cashflowList;
	}

	@Override
	public List<Cashflow> getCashflowList(Long orgId, String shopId, Cashflow cashflow) {
		if (orgId == null || StringUtils.isBlank(shopId) || cashflow == null) {
			return null;
		}

		cashflow.setOrgId(orgId);
		try {
			cashflow.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);

			return null;
		}

		try {
			return cashflowDao.getCashflowList(cashflow);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(cashflow), e);
		}

		return null;
	}

	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public ICashflowDao getCashflowDao() {
		return cashflowDao;
	}

	public void setCashflowDao(ICashflowDao cashflowDao) {
		this.cashflowDao = cashflowDao;
	}

}
