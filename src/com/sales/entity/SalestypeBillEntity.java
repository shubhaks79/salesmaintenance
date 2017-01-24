package com.sales.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "st_bill")
public class SalestypeBillEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "bill_no")
	private String billNo;
	
	@Column(name = "alloted_amount")
	private BigDecimal allotedAmount;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salestypeBill")
	List<SalestypeBillEntityDetail>  salestypeBillDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "st_amount_id", nullable = false)
	SalestypeAmtEntity salestypeAmount;

	@Column(name = "create_user")
	private String createUser;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "modified_user")
	private String modifiedUser;
	
	@Column(name = "modified_date")
	private Timestamp modifiedDate;
	
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

	public List<SalestypeBillEntityDetail> getSalestypeBillDetails() {
		return salestypeBillDetails;
	}

	public void setSalestypeBillDetails(
			List<SalestypeBillEntityDetail> salestypeBillDetails) {
		this.salestypeBillDetails = salestypeBillDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SalestypeAmtEntity getSalestypeAmount() {
		return salestypeAmount;
	}

	public void setSalestypeAmount(SalestypeAmtEntity salestypeAmount) {
		this.salestypeAmount = salestypeAmount;
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
