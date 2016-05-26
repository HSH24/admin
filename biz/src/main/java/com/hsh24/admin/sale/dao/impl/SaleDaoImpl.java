package com.hsh24.admin.sale.dao.impl;

import java.util.List;

import com.hsh24.admin.api.sale.bo.Sale;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.sale.dao.ISaleDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SaleDaoImpl extends BaseDaoImpl implements ISaleDao {

	@Override
	public Sale getStats(Sale sale) {
		return (Sale) getSqlMapClientTemplate().queryForObject("sale.getStats", sale);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sale> getSaleList(Sale sale) {
		if (sale.getShopId() == null) {
			return (List<Sale>) getSqlMapClientTemplate().queryForList("sale.getSaleList1", sale);
		} else {
			return (List<Sale>) getSqlMapClientTemplate().queryForList("sale.getSaleList2", sale);
		}
	}

}
