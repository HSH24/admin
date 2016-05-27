package com.hsh24.admin.api.trade.bo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -648874592640100124L;

	private Long orderId;

	private Long tradeId;

	/**
	 * 商品名称.
	 */
	private String itemName;

	private String itemFilePath;

	/**
	 * sku所对应的销售属性的中文名字串，格式如：Pid1:vid1:pid_name1:vid_name1;Pid2:vid2:pid_name2:vid_name2.
	 */
	private String propertiesName;

	/**
	 * 购买该sku商品的数量.
	 */
	private int quantity;

	/**
	 * 购买价格.
	 */
	private BigDecimal price;

	/**
	 * 涨价或减价.
	 */
	private BigDecimal change;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemFilePath() {
		return itemFilePath;
	}

	public void setItemFilePath(String itemFilePath) {
		this.itemFilePath = itemFilePath;
	}

	public String getPropertiesName() {
		return propertiesName;
	}

	public void setPropertiesName(String propertiesName) {
		this.propertiesName = propertiesName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getChange() {
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

}
