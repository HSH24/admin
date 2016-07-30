package com.hsh24.admin.sale.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.hsh24.admin.api.sale.ISaleService;
import com.hsh24.admin.api.sale.bo.Sale;
import com.hsh24.admin.api.sale.bo.SaleDetail;
import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.sale.dao.ISaleDao;
import com.hsh24.admin.sale.dao.ISaleDetailDao;
import com.wideka.weixin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class SaleServiceImpl implements ISaleService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(SaleServiceImpl.class);

	@Resource
	private IShopService shopService;

	@Resource
	private ISaleDao saleDao;

	@Resource
	private ISaleDetailDao saleDetailDao;

	@Override
	public Sale getStats(Long orgId, String shopId, Sale sale) {
		if (orgId == null || sale == null) {
			return null;
		}

		sale.setOrgId(orgId);

		if (StringUtils.isNotBlank(shopId)) {
			try {
				sale.setShopId(Long.valueOf(shopId));
			} catch (NumberFormatException e) {
				logger.error(e);
			}
		}

		try {
			return saleDao.getStats(sale);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(sale), e);
		}

		return null;
	}

	@Override
	public List<Sale> getSaleList(Long orgId, Sale sale) {
		if (orgId == null || sale == null) {
			return null;
		}

		sale.setOrgId(orgId);

		List<Sale> saleList = null;

		try {
			saleList = saleDao.getSaleList1(sale);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(sale), e);
		}

		if (saleList == null || saleList.size() == 0) {
			return null;
		}

		for (Sale s : saleList) {
			Shop shop = shopService.getShop(s.getShopId());
			if (shop == null) {
				continue;
			}

			s.setShopName(shop.getShopName());
		}

		return saleList;
	}

	@Override
	public List<Sale> getSaleList(Long orgId, String shopId, Sale sale) {
		if (orgId == null || StringUtils.isBlank(shopId) || sale == null) {
			return null;
		}

		sale.setOrgId(orgId);
		try {
			sale.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);

			return null;
		}

		try {
			return saleDao.getSaleList2(sale);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(sale), e);
		}

		return null;
	}

	@Override
	public List<SaleDetail> getSaleDetailList(Long orgId, String shopId, String tradeNo) {
		if (shopId == null || StringUtils.isBlank(shopId) || StringUtils.isBlank(tradeNo)) {
			return null;
		}

		SaleDetail saleDetail = new SaleDetail();
		saleDetail.setOrgId(orgId);
		try {
			saleDetail.setShopId(Long.valueOf(shopId));
		} catch (NumberFormatException e) {
			logger.error(e);

			return null;
		}
		saleDetail.setTradeNo(tradeNo.trim());

		try {
			return saleDetailDao.getSaleDetailList(saleDetail);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(saleDetail), e);
		}

		return null;
	}

}
