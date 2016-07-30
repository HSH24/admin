package com.hsh24.admin.monitor.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hsh24.admin.api.monitor.IActionMonitorService;
import com.hsh24.admin.api.monitor.bo.ActionMonitor;
import com.hsh24.admin.framework.log.Logger4jCollection;
import com.hsh24.admin.framework.log.Logger4jExtend;
import com.hsh24.admin.framework.util.LogUtil;
import com.hsh24.admin.monitor.dao.IActionMonitorDao;

/**
 * action log service.
 * 
 * @author xujiakun
 * 
 */
@Service
public class ActionMonitorServiceImpl implements IActionMonitorService {

	private Logger4jExtend logger = Logger4jCollection.getLogger(ActionMonitorServiceImpl.class);

	@Resource
	private IActionMonitorDao actionMonitorDao;

	@Override
	public boolean createActionMonitor(List<ActionMonitor> logs) {
		if (logs == null) {
			return false;
		}

		try {
			actionMonitorDao.createActionMonitor(logs);
			return true;
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(logs), e);
		}

		return false;
	}

	@Override
	public int getActionMonitorCount(ActionMonitor log) {
		if (log == null) {
			return 0;
		}

		try {
			return actionMonitorDao.getActionMonitorCount(log);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(log), e);
		}

		return 0;
	}

	@Override
	public List<ActionMonitor> getActionMonitorList(ActionMonitor log) {
		if (log == null) {
			return null;
		}

		try {
			return actionMonitorDao.getActionMonitorList(log);
		} catch (Exception e) {
			logger.error(LogUtil.parserBean(log), e);
		}

		return null;
	}

}
