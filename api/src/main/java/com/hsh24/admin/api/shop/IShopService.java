package com.hsh24.admin.api.shop;

import java.util.List;

import com.hsh24.admin.api.shop.bo.Shop;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IShopService {

	/**
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getShop(Long shopId);

	/**
	 * 
	 * @param orgId
	 * @return
	 */
	int getShopCount(Long orgId);

	/**
	 * 
	 * @param orgId
	 * @return
	 */
	List<Shop> getShopList(Long orgId);

}
