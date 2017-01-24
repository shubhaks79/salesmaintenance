package com.sales.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "st_constant")
public class ConstantsEntity extends BaseEntity{

	private static final long serialVersionUID = 1L;
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "constant_type")
	private String constantType;
	
	@Column(name = "constant_id")
	private String constantId;

	@Column(name = "constant_desc")
	private String constantDesc;
	
	
	public String getConstantType() {
		return constantType;
	}

	public void setConstantType(String constantType) {
		this.constantType = constantType;
	}

	public String getConstantId() {
		return constantId;
	}

	public void setConstantId(String constantId) {
		this.constantId = constantId;
	}

	public String getConstantDesc() {
		return constantDesc;
	}

	public void setConstantDesc(String constantDesc) {
		this.constantDesc = constantDesc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
