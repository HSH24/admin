package com.hsh24.admin.portal.action;

import com.hsh24.admin.api.user.bo.User;
import com.hsh24.admin.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
public class PortalAction extends BaseAction {

	private static final long serialVersionUID = 2191525146456353749L;

	/**
	 * 登录首页.
	 * 
	 * @return
	 */
	public String index() {
		User user = this.getUser();
		if (user != null) {
			return NONE;
		}

		return SUCCESS;
	}

	public String home() {
		return SUCCESS;
	}

}
