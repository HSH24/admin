package com.hsh24.admin.api.monitor;

import java.util.List;

import com.hsh24.admin.api.cache.bo.CacheStats;
import com.hsh24.admin.framework.bo.BooleanResult;

/**
 * cacheMonitor.
 * 
 * @author xujiakun
 * 
 */
public interface ICacheMonitorService {

	String ERROR_MESSAGE = "操作失败";

	/**
	 * 
	 * @param cacheStats
	 * @return
	 */
	int getCacheMonitorCount(CacheStats cacheStats);

	/**
	 * 
	 * @param cacheStats
	 * @return
	 */
	List<CacheStats> getCacheMonitorList(CacheStats cacheStats);

	/**
	 * createCacheMonitor.
	 * 
	 * @param cacheStatsList
	 * @return
	 */
	BooleanResult createCacheMonitor(List<CacheStats> cacheStatsList);

}
