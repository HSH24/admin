package com.hsh24.admin.cashflow.dao.impl;

import java.util.List;

import com.hsh24.admin.api.cashflow.bo.Cashflow;
import com.hsh24.admin.cashflow.dao.ICashflowDao;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;

/**
 * 
 * @author JiakunXu
 * 
 */
public class CashflowDaoImpl extends BaseDaoImpl implements ICashflowDao {

	@Override
	public Cashflow getCashflowStats(Cashflow cashflow) {
		return (Cashflow) getSqlMapClientTemplate().queryForObject("cashflow.getCashflowStats", cashflow);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cashflow> getCashflowList(Cashflow cashflow) {
		if (cashflow.getShopId() == null) {
			return (List<Cashflow>) getSqlMapClientTemplate().queryForList("cashflow.getCashflowList1", cashflow);
		} else {
			return (List<Cashflow>) getSqlMapClientTemplate().queryForList("cashflow.getCashflowList2", cashflow);
		}
	}

}
