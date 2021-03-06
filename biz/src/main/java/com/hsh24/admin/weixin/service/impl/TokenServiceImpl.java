package com.hsh24.admin.weixin.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hsh24.admin.api.cache.IMemcachedCacheService;
import com.hsh24.admin.api.weixin.ITokenService;
import com.hsh24.admin.framework.bo.BooleanResult;
import com.hsh24.admin.framework.exception.ServiceException;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.wideka.weixin.api.auth.IAccessTokenService;
import com.wideka.weixin.api.auth.bo.AccessToken;

/**
 * 
 * @author JiakunXu
 * 
 */
@Service
public class TokenServiceImpl implements ITokenService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(TokenServiceImpl.class);

	@Resource
	private IMemcachedCacheService memcachedCacheService;

	@Resource
	private IAccessTokenService accessTokenService;

	@Override
	public BooleanResult getToken(String grantType, String appId, String appSecret) {
		BooleanResult result = new BooleanResult();
		result.setResult(false);

		if (StringUtils.isBlank(grantType)) {
			result.setCode("grantType 不能为空.");
			return result;
		}

		if (StringUtils.isBlank(appId)) {
			result.setCode("appId 不能为空.");
			return result;
		}

		if (StringUtils.isBlank(appSecret)) {
			result.setCode("appSecret 不能为空.");
			return result;
		}

		String token = null;
		String key = grantType.trim() + "&" + appId.trim() + "&" + appSecret.trim();

		try {
			token = (String) memcachedCacheService.get(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, e);
		}

		if (StringUtils.isNotBlank(token)) {
			result.setCode(token);
			result.setResult(true);
			return result;
		}

		AccessToken accessToken = null;

		try {
			accessToken = accessTokenService.getToken(grantType, appId, appSecret);
		} catch (RuntimeException e) {
			logger.error(e);

			result.setCode(e.getMessage());
			return result;
		}

		token = accessToken.getAccessToken();

		try {
			memcachedCacheService.set(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, token,
				accessToken.getExpiresIn());
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, e);
		}

		result.setCode(token);
		result.setResult(true);
		return result;
	}

	@Override
	public BooleanResult getToken(String corpId, String corpSecret) {
		BooleanResult result = new BooleanResult();
		result.setResult(false);

		if (StringUtils.isBlank(corpId)) {
			result.setCode("corpId 不能为空.");
			return result;
		}

		if (StringUtils.isBlank(corpSecret)) {
			result.setCode("corpSecret 不能为空.");
			return result;
		}

		String token = null;
		String key = corpId.trim() + "&" + corpSecret.trim();

		try {
			token = (String) memcachedCacheService.get(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key);
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, e);
		}

		if (StringUtils.isNotBlank(token)) {
			result.setCode(token);
			result.setResult(true);
			return result;
		}

		AccessToken accessToken = null;

		try {
			accessToken = accessTokenService.getToken(corpId, corpSecret);
		} catch (RuntimeException e) {
			logger.error(e);

			result.setCode(e.getMessage());
			return result;
		}

		token = accessToken.getAccessToken();

		try {
			memcachedCacheService.set(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, token,
				accessToken.getExpiresIn());
		} catch (ServiceException e) {
			logger.error(IMemcachedCacheService.CACHE_KEY_WX_TOKEN + key, e);
		}

		result.setCode(token);
		result.setResult(true);
		return result;
	}

}
