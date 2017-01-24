package com.sales.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class SalesTypeAmountVo extends BaseVo{
	private Integer salesTypeId;
	private BigDecimal totalAmount;
	private Timestamp saleDate;
	public Integer getSalesTypeId() {
		return salesTypeId;
	}
	public void setSalesTypeId(Integer salesTypeId) {
		this.salesTypeId = salesTypeId;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Timestamp getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}
}
