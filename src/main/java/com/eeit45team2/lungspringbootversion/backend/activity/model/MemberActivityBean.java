package com.eeit45team2.lungspringbootversion.backend.activity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// 本類別存放訂單資料
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="MemberActivity", 
uniqueConstraints = { @UniqueConstraint(columnNames = {"ac_id","mi_no"}) })
public class MemberActivityBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer orderNo;
	Integer mi_no;
	Integer ac_id;
	
	
	
	public MemberActivityBean(Integer orderNo, Integer mi_no, Integer ac_id) {
		super();
		this.orderNo = orderNo;
		this.mi_no = mi_no;
		this.ac_id = ac_id;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getMi_no() {
		return mi_no;
	}
	public void setMi_no(Integer mi_no) {
		this.mi_no = mi_no;
	}
	public Integer getAc_id() {
		return ac_id;
	}
	public void setAc_id(Integer ac_id) {
		this.ac_id = ac_id;
	}

	
}
