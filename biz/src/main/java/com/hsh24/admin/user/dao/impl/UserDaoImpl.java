package com.hsh24.admin.user.dao.impl;

import com.hsh24.admin.api.user.bo.User;
import com.hsh24.admin.framework.dao.impl.BaseDaoImpl;
import com.hsh24.admin.user.dao.IUserDao;

/**
 * 
 * @author JiakunXu
 * 
 */
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	@Override
	public User getUserByPassport(String passport) {
		return (User) getSqlMapClientTemplate().queryForObject("user.getUserByPassport", passport);
	}

	@Override
	public User getUser(User user) {
		return (User) getSqlMapClientTemplate().queryForObject("user.getUser", user);
	}

	@Override
	public int updateUser(User user) {
		return getSqlMapClientTemplate().update("user.updateUser", user);
	}

}
