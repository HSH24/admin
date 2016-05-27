package com.hsh24.admin.shop.action;

import java.util.List;

import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
public class ShopAction extends BaseAction {

	private static final long serialVersionUID = 4698529978398184206L;

	private IShopService shopService;

	private List<Shop> shopList;

	/**
	 * 
	 * @return
	 */
	public String stats() {
		int count = shopService.getShopCount(this.getOrg().getOrgId());

		this.setResourceResult(count + "&" + count);

		return RESOURCE_RESULT;
	}

	/**
	 * 
	 * @return
	 */
	public String list() {
		shopList = shopService.getShopList(this.getOrg().getOrgId());

		return SUCCESS;
	}

	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public List<Shop> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shop> shopList) {
		this.shopList = shopList;
	}

}
