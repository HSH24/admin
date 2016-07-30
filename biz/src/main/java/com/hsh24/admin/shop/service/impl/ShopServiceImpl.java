package com.hsh24.admin.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hsh24.admin.api.cache.IMemcachedCacheService;
import com.hsh24.admin.api.shop.IShopService;
import com.hsh24.admin.api.shop.bo.Shop;
import com.hsh24.admin.api.user.IUserService;
import com.hsh24.admin.api.user.bo.User;
import com.hsh24.admin.framework.exception.ServiceException;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.shop.dao.IShopDao;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class ShopServiceImpl implements IShopService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(ShopServiceImpl.class);

	@Resource
	private IMemcachedCacheService memcachedCacheService;

	@Resource
	private IUserService userService;

	@Resource
	private IShopDao shopDao;

	@Override
	public Shop getShop(Long shopId) {
		if (shopId == null) {
			return null;
		}

		String key = shopId.toString();

		Shop shop = null;

		try {
			shop = (Shop) memcachedCacheService.get(IMemcachedCacheService.CACHE_KEY_SHOP_ID + key);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_SHOP_ID + key, e);
		}

		if (shop != null) {
			return shop;
		}

		shop = new Shop();
		shop.setShopId(shopId);

		try {
			shop = shopDao.getShop(shop);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(shop), e);

			return null;
		}

		if (shop == null) {
			return null;
		}

		// not null then set to cache
		try {
			memcachedCacheService.set(IMemcachedCacheService.CACHE_KEY_SHOP_ID + key, shop);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_SHOP_ID + key, e);
		}

		return shop;
	}

	@Override
	public int getShopCount(Long orgId) {
		if (orgId == null) {
			return 0;
		}

		Shop shop = new Shop();
		shop.setOrgId(orgId);

		return getOrgShopCount(shop);
	}

	@Override
	public List<Shop> getShopList(Long orgId) {
		if (orgId == null) {
			return null;
		}

		Shop shop = new Shop();
		shop.setOrgId(orgId);

		List<Shop> list = getOrgShopList(shop);

		if (list == null || list.size() == 0) {
			return null;
		}

		List<Shop> shopList = new ArrayList<Shop>();

		for (Shop s : list) {
			Shop sp = getShop(s.getShopId());
			if (sp == null) {
				continue;
			}

			User user = userService.getUser(sp.getUserId());
			if (user != null) {
				sp.setUserName(user.getUserName());
				sp.setTel(user.getPassport());
			}

			shopList.add(sp);
		}

		return shopList;
	}

	/**
	 * 
	 * @param shop
	 * @return
	 */
	private int getOrgShopCount(Shop shop) {
		try {
			return shopDao.getOrgShopCount(shop);
		} catch (Exception e) {
			logger.error(e);
		}

		return 0;
	}

	/**
	 * 
	 * @param shop
	 * @return
	 */
	private List<Shop> getOrgShopList(Shop shop) {
		try {
			return shopDao.getOrgShopList(shop);
		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

}
