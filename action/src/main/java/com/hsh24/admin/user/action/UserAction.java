package com.hsh24.admin.user.action;

import javax.servlet.http.HttpSession;

import com.hsh24.admin.api.user.IUserService;
import com.hsh24.admin.api.user.bo.User;
import com.hsh24.admin.framework.action.BaseAction;
import com.hsh24.admin.framework.annotation.ActionMonitor;
import com.hsh24.admin.framework.bo.BooleanResult;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserAction extends BaseAction {

	private static final long serialVersionUID = 7825329647617901909L;

	private IUserService userService;

	private String userName;

	/**
	 * 
	 * @return
	 */
	public String detail() {
		return SUCCESS;
	}

	public String setUserName() {
		return SUCCESS;
	}

	@ActionMonitor(actionName = "名字设置")
	public String updateUserName() {
		User user = this.getUser();

		BooleanResult result = userService.setUserName(user.getPassport(), userName, user.getUserId().toString());

		if (result.getResult()) {
			user.setUserName(userName.trim());

			HttpSession session = this.getSession();
			session.setAttribute("ACEGI_SECURITY_LAST_LOGINUSER", user);

			this.setResourceResult("设置名字成功");
		} else {
			this.getServletResponse().setStatus(599);
			this.setResourceResult(result.getCode());
		}

		return RESOURCE_RESULT;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}