package com.hsh24.admin.supplier.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hsh24.admin.api.cache.IMemcachedCacheService;
import com.hsh24.admin.api.supplier.ISupplierService;
import com.hsh24.admin.api.supplier.bo.Supplier;
import com.hsh24.admin.framework.exception.ServiceException;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.supplier.dao.ISupplierDao;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class SupplierServiceImpl implements ISupplierService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(SupplierServiceImpl.class);

	@Resource
	private IMemcachedCacheService memcachedCacheService;

	@Resource
	private ISupplierDao supplierDao;

	@Override
	public Supplier getSupplier(Long supId) {
		if (supId == null) {
			return null;
		}

		String key = supId.toString();

		Supplier supplier = null;

		try {
			supplier = (Supplier) memcachedCacheService.get(IMemcachedCacheService.CACHE_KEY_SUP_ID + key);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_SUP_ID + key, e);
		}

		if (supplier != null) {
			return supplier;
		}

		supplier = new Supplier();
		supplier.setSupId(supId);

		try {
			supplier = supplierDao.getSupplier(supplier);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(supplier), e);

			return null;
		}

		if (supplier == null) {
			return null;
		}

		// not null then set to cache
		try {
			memcachedCacheService.set(IMemcachedCacheService.CACHE_KEY_SUP_ID + key, supplier);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_SUP_ID + key, e);
		}

		return supplier;
	}

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

}
