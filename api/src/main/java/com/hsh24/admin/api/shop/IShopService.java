package com.hsh24.admin.api.shop;

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

}
