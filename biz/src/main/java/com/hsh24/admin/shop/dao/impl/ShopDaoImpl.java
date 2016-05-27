package com.hsh24.admin.shop.dao.impl;

import java.util.List;

import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.shop.dao.IShopDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class ShopDaoImpl extends BaseDaoImpl implements IShopDao {

	@Override
	public Shop getShop(Shop shop) {
		return (Shop) getSqlMapClientTemplate().queryForObject("shop.getShop", shop);
	}

	@Override
	public int getOrgShopCount(Shop shop) {
		return (Integer) getSqlMapClientTemplate().queryForObject("shop.getOrgShopCount", shop);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getOrgShopList(Shop shop) {
		return (List<Shop>) getSqlMapClientTemplate().queryForList("shop.getOrgShopList", shop);
	}

}
