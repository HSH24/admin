package com.hsh24.admin.bankAcct.dao.impl;

import com.hsh24.admin.api.bankAcct.bo.BankAcct;
import com.hsh24.admin.bankAcct.dao.IBankAcctDao;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;

/**
 * 
 * @author JiakunXu
 * 
 */
public class BankAcctDaoImpl extends BaseDaoImpl implements IBankAcctDao {

	@Override
	public BankAcct getBankAcctStats(BankAcct bankAcct) {
		return (BankAcct) getSqlMapClientTemplate().queryForObject("bankAcct.getBankAcctStats", bankAcct);
	}

}
