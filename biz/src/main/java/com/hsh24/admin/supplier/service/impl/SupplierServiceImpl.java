package com.hsh24.admin.supplier.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hsh24.admin.api.cache.IMemcachedCacheService;
import com.hsh24.admin.api.supplier.ISupplierService;
import com.hsh24.admin.api.supplier.bo.Supplier;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.supplier.dao.ISupplierDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SupplierServiceImpl implements ISupplierService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(SupplierServiceImpl.class);

	private IMemcachedCacheService memcachedCacheService;

	private ISupplierDao supplierDao;

	@Override
	public Map<Long, Supplier> getSupplier(String[] supId) {
		if (supId == null || supId.length == 0) {
			return null;
		}

		Supplier supplier = new Supplier();
		supplier.setCodes(supId);

		List<Supplier> supplierList = null;

		try {
			supplierList = supplierDao.getSupplierList(supplier);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(supplier), e);
		}

		if (supplierList == null || supplierList.size() == 0) {
			return null;
		}

		Map<Long, Supplier> map = new HashMap<Long, Supplier>();

		for (Supplier sup : supplierList) {
			map.put(sup.getSupId(), sup);
		}

		return map;
	}

	public IMemcachedCacheService getMemcachedCacheService() {
		return memcachedCacheService;
	}

	public void setMemcachedCacheService(IMemcachedCacheService memcachedCacheService) {
		this.memcachedCacheService = memcachedCacheService;
	}

	public ISupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(ISupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

}
