package com.hsh24.admin.stock.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsh24.admin.api.stock.IStockService;
import com.hsh24.admin.api.stock.bo.Stock;
import com.hsh24.admin.framework.action.BaseAction;

/**
 * 
 * @author JiakunXu
 * 
 */
@Controller
@Scope("request")
public class StockAction extends BaseAction {

	private static final long serialVersionUID = 690121423498348832L;

	@Resource
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
