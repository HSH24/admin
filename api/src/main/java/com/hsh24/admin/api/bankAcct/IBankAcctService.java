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
	 * @param shopId
	 * @param accCode
	 * @return
	 */
	BankAcct getBankAcct(Long shopId, String accCode);

}
