package com.hsh24.admin.api.user;

import java.util.List;

import com.hsh24.admin.api.org.bo.Org;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IUserOrgService {

	/**
	 * 
	 * @param userId
	 * @return
	 */
	List<Org> getOrgList(String passport);

}
