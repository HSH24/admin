package com.hsh24.admin.api.supplier;

import java.util.Map;

import com.hsh24.admin.api.supplier.bo.Supplier;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ISupplierService {

	/**
	 * 
	 * @param supId
	 * @return
	 */
	Map<Long, Supplier> getSupplier(String[] supId);

}
