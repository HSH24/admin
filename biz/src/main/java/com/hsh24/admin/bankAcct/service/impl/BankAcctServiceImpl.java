package com.hsh24.admin.bankAcct.service.impl;

import org.apache.commons.lang3.StringUtils;

import com.hsh24.admin.api.bankAcct.IBankAcctService;
import com.hsh24.admin.api.bankAcct.bo.BankAcct;
import com.hsh24.admin.bankAcct.dao.IBankAcctDao;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class BankAcctServiceImpl implements IBankAcctService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(BankAcctServiceImpl.class);

	private IBankAcctDao bankAcctDao;

	@Override
	public BankAcct getBankAcctStats(Long orgId, String accCode) {
		return getBankAcctStats(orgId, null, accCode);
	}

	@Override
	public BankAcct getBankAcctStats(Long orgId, String shopId, String accCode) {
		if (orgId == null || StringUtils.isBlank(accCode)) {
			return null;
		}

		BankAcct bankAcct = new BankAcct();
		bankAcct.setOrgId(orgId);
		if (StringUtils.isNotBlank(shopId)) {
			try {
				bankAcct.setShopId(Long.parseLong(shopId));
			} catch (NumberFormatException e) {
				logger.error(e);

				return null;
			}
		}
		bankAcct.setAccCode(accCode.trim());

		try {
			return bankAcctDao.getBankAcctStats(bankAcct);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(bankAcct), e);
		}

		return null;
	}

	public IBankAcctDao getBankAcctDao() {
		return bankAcctDao;
	}

	public void setBankAcctDao(IBankAcctDao bankAcctDao) {
		this.bankAcctDao = bankAcctDao;
	}

}
