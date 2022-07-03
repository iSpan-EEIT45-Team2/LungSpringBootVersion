package com.eeit45team2.lungspringbootversion.backend.animal.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity //實體類
@Table(name="addog_table") //資料表
@Getter
@Setter
@ToString

public class AdDogBean {
	@Id //主KEY     自動生成                     每次+1
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long adid;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String adname;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String adphone;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String ademail;
	@Column(columnDefinition = "NVARCHAR(50)")
	private String adtype;
	@Column(columnDefinition = "Int")
	private int adage;
	@Column(columnDefinition = "DATE ")
	private String addate;

	public AdDogBean() {
	}

	public AdDogBean(Long adid, String adname, String adphone, String ademail, String adtype, int adage, String addate) {
		this.adid = adid;
		this.adname = adname;
		this.adphone = adphone;
		this.ademail = ademail;
		this.adtype = adtype;
		this.adage = adage;
		this.addate = addate;
	}

	public AdDogBean(String adname, String adphone, String ademail, String adtype, int adage, String addate) {
		this.adname = adname;
		this.adphone = adphone;
		this.ademail = ademail;
		this.adtype = adtype;
		this.adage = adage;
		this.addate = addate;
	}
}



