package com.hsh24.admin.framework.struts.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.hsh24.admin.api.ca.ICAService;
import com.hsh24.admin.api.org.bo.Org;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @author JiakunXu
 * 
 */
@Component
public class AuthenticationInterceptor implements Interceptor {

	private static final long serialVersionUID = -7498838714747075663L;

	private static final String LOGIN_TIMEOUT = "440";

	private ICAService caService;

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {

		@SuppressWarnings("rawtypes")
		Map session = invocation.getInvocationContext().getSession();
		String passport = (String) session.get("ACEGI_SECURITY_LAST_PASSPORT");

		if (StringUtils.isBlank(passport)) {
			String actionName = getActionName();
			// 登录首页 不需要 goto
			if (!"/home.htm".equals(actionName)) {
				setAttribute("goto", getUrl());
			}

			return LOGIN_TIMEOUT;
		}

		Org org = (Org) session.get("ACEGI_SECURITY_LAST_ORG");
		if (org == null) {
			// TODO
			return LOGIN_TIMEOUT;
		}

		return invocation.invoke();
	}

	private String getUrl() {
		// 获取当前applicationContex
		ActionContext ctx = ActionContext.getContext();
		// Map map = ctx.getSession()
		// 设置当前请求的URL
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		StringBuffer url = request.getRequestURL();

		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			return url.toString() + "?" + queryString;
		}

		return url.toString();
	}

	private void setAttribute(String name, Object o) {
		// 获取当前applicationContex
		ActionContext ctx = ActionContext.getContext();
		// Map map = ctx.getSession()
		// 设置当前请求的URL
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		request.setAttribute(name, o);
	}

	/**
	 * actionName.
	 * 
	 * @return
	 */
	private String getActionName() {
		String actionName = null;
		// 获取当前applicationContex
		ActionContext ctx = ActionContext.getContext();
		// Map map = ctx.getSession()
		// 设置当前请求的URL
		HttpServletRequest request = (HttpServletRequest) ctx.get(ServletActionContext.HTTP_REQUEST);
		StringBuffer url = request.getRequestURL();
		int index = url.lastIndexOf(request.getContextPath()) + request.getContextPath().length();
		actionName = url.substring(index, url.length());
		return actionName;
	}

	public ICAService getCaService() {
		return caService;
	}

	public void setCaService(ICAService caService) {
		this.caService = caService;
	}

}
