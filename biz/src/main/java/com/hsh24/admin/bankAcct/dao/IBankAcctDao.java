package com.hsh24.admin.bankAcct.dao;

import com.hsh24.admin.api.bankAcct.bo.BankAcct;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IBankAcctDao {

	/**
	 * 
	 * @param bankAcct
	 * @return
	 */
	BankAcct getBankAcctStats(BankAcct bankAcct);

}
