package com.hsh24.admin.sale.service.impl;

import java.util.List;

import com.hsh24.admin.api.sale.ISaleService;
import com.hsh24.admin.api.sale.bo.Sale;
import com.hsh24.admin.api.sale.bo.SaleDetail;
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
public class SaleServiceImpl implements ISaleService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(SaleServiceImpl.class);

	private ISaleDao saleDao;

	private ISaleDetailDao saleDetailDao;

	@Override
	public Sale getStats(Long orgId, Sale sale) {
		if (orgId == null || sale == null) {
			return null;
		}

		sale.setOrgId(orgId);

		try {
			return saleDao.getStats(sale);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(sale), e);
		}

		return null;
	}

	@Override
	public List<Sale> getSaleList(Long orgId, Sale sale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> getSaleList(Long orgId, String shopId, Sale sale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SaleDetail> getSaleDetailList(Long orgId, String shopId, String tradeNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ISaleDao getSaleDao() {
		return saleDao;
	}

	public void setSaleDao(ISaleDao saleDao) {
		this.saleDao = saleDao;
	}

	public ISaleDetailDao getSaleDetailDao() {
		return saleDetailDao;
	}

	public void setSaleDetailDao(ISaleDetailDao saleDetailDao) {
		this.saleDetailDao = saleDetailDao;
	}

}
