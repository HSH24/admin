package com.hsh24.admin.stock.action;

import java.util.List;

import com.hsh24.admin.api.stock.IStockService;
import com.hsh24.admin.api.stock.bo.Stock;
import com.hsh24.admin.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
public class StockAction extends BaseAction {

	private static final long serialVersionUID = 690121423498348832L;

	private IStockService stockService;

	private List<Stock> stockList;

	private String shopId;

	/**
	 * 首页 库存统计.
	 * 
	 * @return
	 */
	public String stats() {
		Stock stock = stockService.getStats(this.getOrg().getOrgId());
		this.setResourceResult(stock == null ? "0" : String.valueOf(stock.getStock()));

		return RESOURCE_RESULT;
	}

	public String shop() {
		stockList = stockService.getStockList(this.getOrg().getOrgId(), new Stock());

		return SUCCESS;
	}

	/**
	 * 首页.
	 * 
	 * @return
	 */
	public String list() {
		stockList = stockService.getStockList(this.getOrg().getOrgId(), shopId, new Stock());

		return SUCCESS;
	}

	public IStockService getStockService() {
		return stockService;
	}

	public void setStockService(IStockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(List<Stock> stockList) {
		this.stockList = stockList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}
