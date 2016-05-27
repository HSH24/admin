package com.hsh24.admin.api.trade.bo;

import java.io.Serializable;

/**
 * 
 * @author JiakunXu
 * 
 */
public class Order implements Serializable {

	private static final long serialVersionUID = -648874592640100124L;

	private Long tradeId;

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

}
