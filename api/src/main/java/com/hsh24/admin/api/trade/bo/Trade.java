package com.hsh24.admin.api.trade.bo;

import java.math.BigDecimal;
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

	private BigDecimal tradePrice;

	private BigDecimal change = BigDecimal.ZERO;

	/**
	 * tosend: 待发货; send: 已发货; sign: 标记签收; cancel: 已关闭; feedback: 维权订单; feedbacked: 已处理维权订单.
	 */
	private String type;

	private String tradeNo;

	private String payDate;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	private Long orgId;

	private String shopName;

	private int amount;

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

	public BigDecimal getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(BigDecimal tradePrice) {
		this.tradePrice = tradePrice;
	}

	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	/**
	 * 实付金额 tradePrice + (change).
	 * 
	 * @return
	 */
	public BigDecimal getPrice() {
		if (this.tradePrice != null) {
			return this.tradePrice.add(this.change);
		}

		return BigDecimal.ZERO;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
