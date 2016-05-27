package com.hsh24.admin.user.dao;

import com.hsh24.admin.api.user.bo.User;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IUserDao {

	/**
	 * 
	 * @param passport
	 * @return
	 */
	User getUserByPassport(String passport);

	/**
	 * 
	 * @param user
	 * @return
	 */
	User getUser(User user);

	/**
	 * 
	 * @param user
	 * @return
	 */
	int updateUser(User user);

}
