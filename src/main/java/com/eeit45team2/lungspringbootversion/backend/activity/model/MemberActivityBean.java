package com.eeit45team2.lungspringbootversion.backend.activity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// 本類別存放訂單資料
import javax.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@Table(name="MemberActivity",
uniqueConstraints = { @UniqueConstraint(columnNames = {"ac_id","mi_no"}) })
public class MemberActivityBean {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer orderNo;
	Integer mi_no;
	Integer ac_id;
	LocalDateTime date;



	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public MemberActivityBean(Integer orderNo, Integer mi_no, Integer ac_id) {
		super();
		this.orderNo = orderNo;
		this.mi_no = mi_no;
		this.ac_id = ac_id;
	}

	public MemberActivityBean() {

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
