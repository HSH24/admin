package com.hsh24.admin.api.cashflow;

import java.util.List;

import com.hsh24.admin.api.cashflow.bo.Cashflow;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ICashflowService {

	/**
	 * 
	 * @param orgId
	 * @return
	 */
	Cashflow getCashflowStats(Long orgId);

	/**
	 * 
	 * @param orgId
	 * @param code
	 * @return
	 */
	Cashflow getCashflowStats(Long orgId, String code);

	/**
	 * 
	 * @param orgId
	 * @param cashflow
	 * @return
	 */
	List<Cashflow> getCashflowList(Long orgId, Cashflow cashflow);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param cashflow
	 * @return
	 */
	List<Cashflow> getCashflowList(Long orgId, String shopId, Cashflow cashflow);

}
