package com.hsh24.admin.api.sale.bo;

import java.math.BigDecimal;

import com.hsh24.admin.framework.bo.SearchInfo;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Sale extends SearchInfo {

	private static final long serialVersionUID = 4733426047070262299L;

	/**
	 * 店铺.
	 */
	private Long shopId;

	private String tradeNo;

	private BigDecimal amount;

	private String tradeDate;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	private Long orgId;

	private String shopName;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
