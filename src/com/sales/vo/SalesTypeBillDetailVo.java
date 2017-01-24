package com.sales.vo;

import java.math.BigDecimal;

public class SalesTypeBillDetailVo extends BaseVo {
	private Integer returnDesc;

	private BigDecimal returnAmount;

	public Integer getReturnDesc() {
		return returnDesc;
	}

	public void setReturnDesc(Integer returnDesc) {
		this.returnDesc = returnDesc;
	}

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}
}
