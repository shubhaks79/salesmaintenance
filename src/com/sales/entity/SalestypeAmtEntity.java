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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "st_amount")
public class SalestypeAmtEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	

	@Column(name = "salestype_id")
	private Integer salesTypeId;
	
	@Column(name = "total_amount")
	private BigDecimal totalAmount;
	
	@Column(name = "sales_date")
	private Timestamp saleDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salestypeAmount")
	List<SalestypeBillEntity> salestypeBill;

	@Column(name = "create_user")
	private String createUser;
	
	@Column(name = "create_date")
	private Timestamp createDate;
	
	@Column(name = "update_user")
	private String modifiedUser;
	
	@Column(name = "update_date")
	private Timestamp modifiedDate;

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

	public List<SalestypeBillEntity> getSalestypeBill() {
		return salestypeBill;
	}

	public void setSalestypeBill(List<SalestypeBillEntity> salestypeBill) {
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
