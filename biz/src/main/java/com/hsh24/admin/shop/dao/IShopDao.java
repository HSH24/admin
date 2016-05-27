package com.hsh24.admin.shop.dao;

import java.util.List;

import com.hsh24.admin.api.shop.bo.Shop;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IShopDao {

	/**
	 * 
	 * @param shop
	 * @return
	 */
	Shop getShop(Shop shop);

	/**
	 * 
	 * @param shop
	 * @return
	 */
	int getOrgShopCount(Shop shop);

	/**
	 * 
	 * @param shop
	 * @return
	 */
	List<Shop> getOrgShopList(Shop shop);

}
