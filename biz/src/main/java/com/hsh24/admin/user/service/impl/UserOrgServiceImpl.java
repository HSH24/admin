package com.hsh24.admin.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.hsh24.admin.api.org.bo.Org;
import com.hsh24.admin.api.user.IUserOrgService;
import com.hsh24.admin.api.user.IUserService;
import com.hsh24.admin.api.user.bo.User;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserOrgServiceImpl implements IUserOrgService {

	private IUserService userService;

	@Override
	public List<Org> getOrgList(String passport) {
		if (StringUtils.isBlank(passport)) {
			return null;
		}

		User user = userService.getUser(passport);
		if (user == null) {
			return null;
		}

		Org org = new Org();
		org.setOrgId(user.getOrgId());

		List<Org> orgList = new ArrayList<Org>();
		orgList.add(org);

		return orgList;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
