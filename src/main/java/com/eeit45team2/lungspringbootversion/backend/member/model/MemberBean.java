package com.eeit45team2.lungspringbootversion.backend.member.model;

import java.sql.Blob;
import java.sql.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "MemberTable",
	uniqueConstraints = { @UniqueConstraint(columnNames = "mi_account") })
@Getter
@Setter
@ToString
public class MemberBean {
	@Id   //PK值
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //SQL自動新增
	Long mi_no;  // 會員編號
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String mi_name;  // 會員姓名
	
	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	String mi_id;  // 會員身分證
	
	@Column(columnDefinition = "DATE NOT NULL")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+8")
	Date mi_birth;  // 會員生日
	
	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	String mi_phone;  // 會員電話
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String mi_email;  // 會員Email
	
	@Column(columnDefinition = "NVARCHAR(100) NOT NULL")
	String mi_address;  // 會員地址
	
	@Column(name="mi_account" , columnDefinition = "NVARCHAR(100) NOT NULL")
	String miAccount;  // 會員帳號 //UK
	
	@Column(name="mi_password" ,columnDefinition = "NVARCHAR(500) NOT NULL")
	String miPassword;  // 會員密碼
	
	
	String localfileName;

	@Lob
	Blob image;
	
	@Transient
	MultipartFile productImage;

	@Column(name="TYPE", length=15, nullable=false)
	private String type = UserAuthority.USER.getUserAuthority();


	//All Constructor  //9個欄位
	public MemberBean(Long mi_no, String mi_name, String mi_id, Date mi_birth, String mi_phone, String mi_email,
			String mi_address, String miAccount, String miPassword) {
		super();
		this.mi_no = mi_no;
		this.mi_name = mi_name;
		this.mi_id = mi_id;
		this.mi_birth = mi_birth;
		this.mi_phone = mi_phone;
		this.mi_email = mi_email;
		this.mi_address = mi_address;
		this.miAccount = miAccount;
		this.miPassword = miPassword;
	}
	
	//Constructor without mi_no  //8個欄位
	public MemberBean(String mi_name, String mi_id, Date mi_birth, String mi_phone, String mi_email, String mi_address,
			String miAccount, String miPassword) {
		super();
		this.mi_name = mi_name;
		this.mi_id = mi_id;
		this.mi_birth = mi_birth;
		this.mi_phone = mi_phone;
		this.mi_email = mi_email;
		this.mi_address = mi_address;
		this.miAccount = miAccount;
		this.miPassword = miPassword;
	}
	
	// Constructor with account and password
	public MemberBean(String miAccount, String miPassword) {
		super();
		this.miAccount = miAccount;
		this.miPassword = miPassword;
	}

	public MemberBean(Long mi_no) {
		super();
		this.mi_no = mi_no;
	}

	// Constructor with nothing
	public MemberBean() {
	}



}