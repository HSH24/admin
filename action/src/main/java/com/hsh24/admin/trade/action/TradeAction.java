package com.hsh24.admin.trade.action;

import java.util.List;

import com.hsh24.admin.api.trade.ITradeService;
import com.hsh24.admin.api.trade.bo.Trade;
import com.hsh24.admin.framework.action.BaseAction;
import com.hsh24.admin.framework.util.FormatUtil;

public class TradeAction extends BaseAction {

	private static final long serialVersionUID = 5383400445408274054L;

	private ITradeService tradeService;

	private String type;

	private List<Trade> tradeList;

	private String shopId;

	private String tradeNo;

	private Trade trade;

	/**
	 * 订单数据统计.
	 * 
	 * @return
	 */
	public String stats() {
		StringBuilder sb = new StringBuilder();

		Long orgId = this.getOrg().getOrgId();

		if ("tosend".equals(type)) {
			sb.append(FormatUtil.getAmountFormat(tradeService.getTradePrice(orgId, new String[] { "tosend" }))).append(
				"&");
			sb.append(tradeService.getTradeCount(orgId, new String[] { "tosend" }));

			this.setResourceResult(sb.toString());
		}

		return RESOURCE_RESULT;
	}

	public String shop() {
		Long orgId = this.getOrg().getOrgId();

		if ("tosend".equals(type)) {
			tradeList = tradeService.getTradeList(orgId, new String[] { "tosend" });
		}

		return SUCCESS;
	}

	/**
	 * 订单列表.
	 * 
	 * @return
	 */
	public String list() {
		Long orgId = this.getOrg().getOrgId();

		if ("tosend".equals(type)) {
			tradeList = tradeService.getTradeList(orgId, shopId, new String[] { "tosend" });
		}

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String detail() {
		trade = tradeService.getTrade(this.getOrg().getOrgId(), shopId, tradeNo);

		return SUCCESS;
	}

	public ITradeService getTradeService() {
		return tradeService;
	}

	public void setTradeService(ITradeService tradeService) {
		this.tradeService = tradeService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Trade> getTradeList() {
		return tradeList;
	}

	public void setTradeList(List<Trade> tradeList) {
		this.tradeList = tradeList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}

}
