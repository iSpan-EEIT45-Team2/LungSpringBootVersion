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
	uniqueConstraints = { @UniqueConstraint(columnNames = "miAccount") })
@Getter
@Setter
@ToString
public class MemberBean {
	@Id   //PK值
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //SQL自動新增
	Long miNo;  // 會員編號
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String miName;  // 會員姓名
	
	@Column(columnDefinition = "NVARCHAR(20)")
	String miId;  // 會員身分證
	
	@Column(columnDefinition = "DATE NOT NULL")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="GMT+8")
	Date miBirth;  // 會員生日
	
	@Column(columnDefinition = "NVARCHAR(20) NOT NULL")
	String miPhone;  // 會員電話
	
	@Column(columnDefinition = "NVARCHAR(50) NOT NULL")
	String miEmail;  // 會員Email
	
	@Column(columnDefinition = "NVARCHAR(100) NOT NULL")
	String miAddress;  // 會員地址
	
	@Column(columnDefinition = "NVARCHAR(100) NOT NULL")
	String miAccount;  // 會員帳號 //UK
	
	@Column(columnDefinition = "NVARCHAR(500) NOT NULL")
	String miPassword;  // 會員密碼
	
	
	String localfileName;

	@Lob
	Blob image;
	
	@Transient
	MultipartFile productImage;

	@Column(name="TYPE", length=15, nullable=false)
	private String type = UserAuthority.USER.getUserAuthority();

	@Column(columnDefinition = "NVARCHAR(100) NOT NULL")
	String miGender;

	//All Constructor  //9個欄位

	
	//Constructor without mi_no  //8個欄位

	
	// Constructor with account and password
	public MemberBean(String miAccount, String miPassword) {
		super();
		this.miAccount = miAccount;
		this.miPassword = miPassword;
	}

	public MemberBean(Long miNo) {
		super();
		this.miNo = miNo;
	}

	// Constructor with nothing
	public MemberBean() {
	}



}