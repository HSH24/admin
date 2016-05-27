package com.hsh24.admin.sale.action;

import java.util.List;

import com.hsh24.admin.api.sale.ISaleService;
import com.hsh24.admin.api.sale.bo.Sale;
import com.hsh24.admin.api.sale.bo.SaleDetail;
import com.hsh24.admin.framework.action.BaseAction;
import com.hsh24.admin.framework.util.DateUtil;
import com.hsh24.admin.framework.util.FormatUtil;

/**
 * 
 * @author JiakunXu
 * 
 */
public class SaleAction extends BaseAction {

	private static final long serialVersionUID = -486178851207623062L;

	private ISaleService saleService;

	private List<Sale> saleList;

	private String tradeNo;

	private List<SaleDetail> saleDetailList;

	private String shopId;

	private String curMonth;

	private String curYear;

	/**
	 * 首页 销售统计.
	 * 
	 * @return
	 */
	public String stats() {
		StringBuilder sb = new StringBuilder();

		Sale sale = new Sale();

		String date = DateUtil.getNowDateStr();
		sale.setGmtStart(date + " 00:00:00");
		sale.setGmtEnd(date + " 23:59:59");
		sale = saleService.getStats(this.getOrg().getOrgId(), shopId, sale);
		sb.append(sale == null ? "0.00" : FormatUtil.getAmountFormat(sale.getAmount())).append("&");

		sale = new Sale();

		String yyyy = String.valueOf(DateUtil.getYear());
		String mm = String.valueOf(DateUtil.getMonth());
		sale.setGmtStart(yyyy + "-" + mm + "-01 00:00:00");
		sale.setGmtEnd(yyyy + "-" + mm + "-31 23:59:59");
		sale = saleService.getStats(this.getOrg().getOrgId(), shopId, sale);
		sb.append(sale == null ? "0.00" : FormatUtil.getAmountFormat(sale.getAmount()));

		this.setResourceResult(sb.toString());

		return RESOURCE_RESULT;
	}

	/**
	 * 销售列表 维度：店铺.
	 * 
	 * @return
	 */
	public String shop() {
		Sale sale = new Sale();
		String yyyy = String.valueOf(DateUtil.getYear());
		String mm = String.valueOf(DateUtil.getMonth());
		curYear = yyyy;
		curMonth = mm;
		sale.setGmtStart(yyyy + "-" + mm + "-01 00:00:00");
		sale.setGmtEnd(yyyy + "-" + mm + "-31 23:59:59");

		saleList = saleService.getSaleList(this.getOrg().getOrgId(), sale);

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String list() {
		Sale sale = new Sale();
		String yyyy = String.valueOf(DateUtil.getYear());
		String mm = String.valueOf(DateUtil.getMonth());
		sale.setGmtStart(yyyy + "-" + mm + "-01 00:00:00");
		sale.setGmtEnd(yyyy + "-" + mm + "-31 23:59:59");

		saleList = saleService.getSaleList(this.getOrg().getOrgId(), shopId, sale);

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String detail() {
		saleDetailList = saleService.getSaleDetailList(this.getOrg().getOrgId(), shopId, tradeNo);

		return SUCCESS;
	}

	public ISaleService getSaleService() {
		return saleService;
	}

	public void setSaleService(ISaleService saleService) {
		this.saleService = saleService;
	}

	public List<Sale> getSaleList() {
		return saleList;
	}

	public void setSaleList(List<Sale> saleList) {
		this.saleList = saleList;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public List<SaleDetail> getSaleDetailList() {
		return saleDetailList;
	}

	public void setSaleDetailList(List<SaleDetail> saleDetailList) {
		this.saleDetailList = saleDetailList;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getCurMonth() {
		return curMonth;
	}

	public void setCurMonth(String curMonth) {
		this.curMonth = curMonth;
	}

	public String getCurYear() {
		return curYear;
	}

	public void setCurYear(String curYear) {
		this.curYear = curYear;
	}

}
