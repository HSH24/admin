package com.hsh24.admin.api.bankAcct;

import com.hsh24.admin.api.bankAcct.bo.BankAcct;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IBankAcctService {

	/**
	 * 
	 * @param orgId
	 * @param accCode
	 * @return
	 */
	BankAcct getBankAcctStats(Long orgId, String accCode);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param accCode
	 * @return
	 */
	BankAcct getBankAcctStats(Long orgId, String shopId, String accCode);

}
