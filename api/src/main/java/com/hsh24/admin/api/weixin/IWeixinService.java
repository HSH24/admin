package com.hsh24.admin.api.weixin;

import com.hsh24.admin.api.weixin.bo.Ticket;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface IWeixinService {

	/**
	 * 
	 * @param url
	 * @return
	 */
	Ticket getTicket(String url);

}
