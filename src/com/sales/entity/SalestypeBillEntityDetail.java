package com.sales.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "st_bill_detail")
public class SalestypeBillEntityDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
		
	@Column(name = "st_return_desc")
	private Integer returnDesc;
	
	@Column(name = "returned_amount")
	private BigDecimal returnAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "st_bill_id", nullable = false)
	SalestypeBillEntity salestypeBill;

	@Column(name = "create_user")
	private String createUser;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "modified_user")
	private String modifiedUser;
	
	@Column(name = "modified_date")
	private Timestamp modifiedDate;


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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SalestypeBillEntity getSalestypeBill() {
		return salestypeBill;
	}

	public void setSalestypeBill(SalestypeBillEntity salestypeBill) {
		this.salestypeBill = salestypeBill;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	public Timestamp getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
