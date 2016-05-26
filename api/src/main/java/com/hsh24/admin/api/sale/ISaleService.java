package com.hsh24.admin.api.sale;

import java.util.List;

import com.hsh24.admin.api.sale.bo.Sale;
import com.hsh24.admin.api.sale.bo.SaleDetail;

/**
 * 
 * @author JiakunXu
 * 
 */
public interface ISaleService {

	/**
	 * 
	 * @param orgId
	 * @param sale
	 * @return
	 */
	Sale getStats(Long orgId, Sale sale);

	/**
	 * 
	 * @param orgId
	 * @param sale
	 * @return
	 */
	List<Sale> getSaleList(Long orgId, Sale sale);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param sale
	 * @return
	 */
	List<Sale> getSaleList(Long orgId, String shopId, Sale sale);

	/**
	 * 
	 * @param orgId
	 * @param shopId
	 * @param tradeNo
	 * @return
	 */
	List<SaleDetail> getSaleDetailList(Long orgId, String shopId, String tradeNo);

}
