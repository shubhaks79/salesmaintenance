package com.sales.vo;

import java.math.BigDecimal;

public class SalesTypeBillVo extends BaseVo {
	private String billNo;
	private BigDecimal allotedAmount;



	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public BigDecimal getAllotedAmount() {
		return allotedAmount;
	}

	public void setAllotedAmount(BigDecimal allotedAmount) {
		this.allotedAmount = allotedAmount;
	}
}
