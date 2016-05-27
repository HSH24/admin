package com.hsh24.admin.supplier.dao.impl;

import java.util.List;

import com.hsh24.admin.api.supplier.bo.Supplier;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.supplier.dao.ISupplierDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SupplierDaoImpl extends BaseDaoImpl implements ISupplierDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> getSupplierList(Supplier supplier) {
		return (List<Supplier>) getSqlMapClientTemplate().queryForList("supplier.getSupplierList", supplier);
	}

}
