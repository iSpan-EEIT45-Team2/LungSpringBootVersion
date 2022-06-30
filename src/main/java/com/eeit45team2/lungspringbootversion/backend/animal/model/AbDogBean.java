package com.eeit45team2.lungspringbootversion.backend.animal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;



@Entity //實體類
@Table(name="abdog_table") //資料表
@Getter
@Setter
@ToString

public class AbDogBean {
	@Id //主KEY     自動生成                     每次+1
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long abid;
	@Column(columnDefinition = "NVARCHAR(50)")

	private String abname;
	@Column(columnDefinition = "NVARCHAR(50)")

	private String abphone;
	@Column(columnDefinition = "NVARCHAR(50)")

	private String abemail;

	private String abphonto;
	@Column(columnDefinition = "NVARCHAR(50)")

	private String abtype;
	@Column(columnDefinition = "Int")
	private int abage;
	@Column(columnDefinition = "DATE ")

	private String abdate;

	public AbDogBean() {
	}

	public AbDogBean(Long abid, String abname, String abphone, String abemail, String abimage, String abtype, int abage, String abdate) {
		this.abid = abid;
		this.abname = abname;
		this.abphone = abphone;
		this.abemail = abemail;
		this.abphonto = abphonto;
		this.abtype = abtype;
		this.abage = abage;
		this.abdate = abdate;
	}

	public AbDogBean(String abname, String abphone, String abemail, String abimage, String abtype, int abage, String abdate) {
		this.abname = abname;
		this.abphone = abphone;
		this.abemail = abemail;
		this.abphonto = abphonto;
		this.abtype = abtype;
		this.abage = abage;
		this.abdate = abdate;
	}
}



