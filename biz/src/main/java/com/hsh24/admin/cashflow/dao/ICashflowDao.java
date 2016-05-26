package com.hsh24.admin.cashflow.dao;

import java.util.List;

import com.hsh24.admin.api.cashflow.bo.Cashflow;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ICashflowDao {

	/**
	 * 
	 * @param cashflow
	 * @return
	 */
	Cashflow getCashflowStats(Cashflow cashflow);

	/**
	 * 
	 * @param cashflow
	 * @return
	 */
	List<Cashflow> getCashflowList(Cashflow cashflow);

}
