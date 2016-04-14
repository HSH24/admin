package com.wideka.admin.api.auth;

import com.wideka.admin.framework.bo.BooleanResult;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IAuthService {

	/**
	 * 
	 * @param redirectUrl
	 * @return
	 */
	BooleanResult authorize(String redirectUrl);

	/**
	 * 
	 * @param redirectUrl
	 * @param state
	 * @return
	 */
	BooleanResult authorize(String redirectUrl, String state);

	/**
	 * 
	 * @param code
	 * @return
	 */
	String getOpenId(String code);

}
