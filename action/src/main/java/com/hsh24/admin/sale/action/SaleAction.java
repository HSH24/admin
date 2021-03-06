package com.hsh24.admin.sale.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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
@Controller
@Scope("request")
public class SaleAction extends BaseAction {

	private static final long serialVersionUID = -486178851207623062L;

	@Resource
	private ISaleService saleService;

	private List<Sale> saleList;

	private String tradeNo;

	private List<SaleDetail> saleDetailList;

	private String shopId;

	private String year;

	private String month;

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

		int yyyy = DateUtil.getYear();
		int mm = DateUtil.getMonth();
		sale.setGmtStart(yyyy + "-" + mm + "-01 00:00:00");
		sale.setGmtEnd(DateUtil.datetime(DateUtil.getLastDayOfLastMonth(yyyy, mm), DateUtil.DEFAULT_DATE_FORMAT)
			+ " 23:59:59");
		sale = saleService.getStats(this.getOrg().getOrgId(), shopId, sale);
		sb.append(sale == null ? "0.00" : FormatUtil.getAmountFormat(sale.getAmount()));

		this.setResourceResult(sb.toString());

		return RESOURCE_RESULT;
	}

	/**
	 * 
	 * @param sale
	 * @return
	 */
	private Sale init(Sale sale) {
		if (StringUtils.isBlank(year)) {
			year = String.valueOf(DateUtil.getYear());
		}

		if (StringUtils.isBlank(month)) {
			month = String.valueOf(DateUtil.getMonth());
		}

		sale.setGmtStart(year + "-" + month + "-01 00:00:00");
		sale.setGmtEnd(DateUtil.datetime(
			DateUtil.getLastDayOfLastMonth(Integer.parseInt(year), Integer.parseInt(month)),
			DateUtil.DEFAULT_DATE_FORMAT) + " 23:59:59");

		return sale;
	}

	/**
	 * 销售列表 维度：店铺.
	 * 
	 * @return
	 */
	public String shop() {
		saleList = saleService.getSaleList(this.getOrg().getOrgId(), init(new Sale()));

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String list() {
		saleList = saleService.getSaleList(this.getOrg().getOrgId(), shopId, init(new Sale()));

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
