package com.hsh24.admin.cashflow.action;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hsh24.admin.api.bankAcct.IBankAcctService;
import com.hsh24.admin.api.bankAcct.bo.BankAcct;
import com.hsh24.admin.api.cashflow.ICashflowService;
import com.hsh24.admin.api.cashflow.bo.Cashflow;
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
public class CashflowAction extends BaseAction {

	private static final long serialVersionUID = -3907855176084554755L;

	@Resource
	private ICashflowService cashflowService;

	@Resource
	private IBankAcctService bankAcctService;

	private List<Cashflow> cashflowList;

	private String type;

	private String shopId;

	private String year;

	private String month;

	/**
	 * 
	 * @return
	 */
	public String stats() {
		StringBuilder sb = new StringBuilder();

		Long orgId = this.getOrg().getOrgId();

		Cashflow cashflow = cashflowService.getCashflowStats(orgId, shopId, "C");
		BigDecimal crAmount = cashflow == null ? BigDecimal.ZERO : cashflow.getDrAmount();

		cashflow = cashflowService.getCashflowStats(orgId, shopId, "B");
		sb.append(
			FormatUtil.getAmountFormat(cashflow == null ? BigDecimal.ZERO : cashflow.getCrAmount().add(
				crAmount.negate()))).append("&");

		BankAcct bankAcct = bankAcctService.getBankAcctStats(orgId, shopId, "1001");
		sb.append(FormatUtil.getAmountFormat(bankAcct == null ? BigDecimal.ZERO : bankAcct.getCurBal()));

		this.setResourceResult(sb.toString());

		return RESOURCE_RESULT;
	}

	/**
	 * 
	 * @param cashflow
	 * @return
	 */
	private Cashflow init(Cashflow cashflow) {
		if (StringUtils.isBlank(year)) {
			year = String.valueOf(DateUtil.getYear());
		}

		if (StringUtils.isBlank(month)) {
			month = String.valueOf(DateUtil.getMonth());
		}

		cashflow.setGmtStart(year + "-" + month + "-01 00:00:00");
		cashflow.setGmtEnd(DateUtil.datetime(
			DateUtil.getLastDayOfLastMonth(Integer.parseInt(year), Integer.parseInt(month)),
			DateUtil.DEFAULT_DATE_FORMAT) + " 23:59:59");

		return cashflow;
	}

	/**
	 * 
	 * @return
	 */
	public String shop() {
		cashflowList = cashflowService.getCashflowStats(this.getOrg().getOrgId(), init(new Cashflow()));

		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 */
	public String list() {
		cashflowList = cashflowService.getCashflowList(this.getOrg().getOrgId(), shopId, init(new Cashflow()));

		return SUCCESS;
	}

	public List<Cashflow> getCashflowList() {
		return cashflowList;
	}

	public void setCashflowList(List<Cashflow> cashflowList) {
		this.cashflowList = cashflowList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
