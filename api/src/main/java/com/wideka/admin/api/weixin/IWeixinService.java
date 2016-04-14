package com.wideka.admin.api.weixin;

import com.wideka.admin.api.weixin.bo.Ticket;

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
