package com.hsh24.admin.monitor.dao;

import java.util.List;

import com.hsh24.admin.api.monitor.bo.LogMonitor;

/**
 * 
 * @author xujiakun
 * 
 */
public interface ILogMonitorDao {

	/**
	 * 
	 * @param logMonitor
	 * @return
	 */
	int getLogMonitorCount(LogMonitor logMonitor);

	/**
	 * 
	 * @param logMonitor
	 * @return
	 */
	List<LogMonitor> getLogMonitorList(LogMonitor logMonitor);

	/**
	 * 
	 * @param logMonitorList
	 * @return
	 */
	int createLogMonitor(List<LogMonitor> logMonitorList);

	/**
	 * 
	 * @return
	 */
	List<LogMonitor> getLogMonitorList4SendEmail();

}
