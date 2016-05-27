package com.hsh24.admin.api.trade.bo;

import java.util.List;

import com.hsh24.admin.framework.bo.SearchInfo;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Trade extends SearchInfo {

	private static final long serialVersionUID = -9214040717302438581L;

	private Long tradeId;

	private Long shopId;

	private Long supId;

	private String tradeNo;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	private Long orgId;

	private String shopName;

	private String supName;

	private List<Order> orderList;

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public Long getSupId() {
		return supId;
	}

	public void setSupId(Long supId) {
		this.supId = supId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
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

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
