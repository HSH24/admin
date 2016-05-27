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

	private String address;

	/**
	 * 亭主.
	 */
	private Long userId;

	// >>>>>>>>>>以下是辅助属性<<<<<<<<<<

	private Long orgId;

	private String userName;

	private String tel;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
