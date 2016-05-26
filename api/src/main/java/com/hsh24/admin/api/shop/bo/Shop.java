package com.hsh24.admin.api.shop.bo;

import java.io.Serializable;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Shop implements Serializable {

	private static final long serialVersionUID = 7722809108753657554L;

	private Long shopId;

	private String shopName;

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
