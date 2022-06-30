package com.eeit45team2.lungspringbootversion.backend.announce.model;

import javax.persistence.*;

@Entity
@Table(name = "ANNOUNCE_Table")
public class AnnounceBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long anNo;
	String anTitle;
	String anContent;
	String anType;
	String anEditor;


	public AnnounceBean() {
	}

	public AnnounceBean(String anTitle, String anContent, String anType, String anEditor, Integer anDate,
						Integer od_money) {
		super();
		this.anTitle = anTitle;
		this.anContent = anContent;
		this.anType = anType;
		this.anEditor = anEditor;
		this.anDate = anDate;
	}

	public AnnounceBean(Long anNo, String anTitle, String anContent, String anType, String anEditor,
						Integer anDate) {
		super();
		this.anNo = anNo;
		this.anTitle = anTitle;
		this.anContent = anContent;
		this.anType = anType;
		this.anEditor = anEditor;
		this.anDate = anDate;
	}

	public AnnounceBean(Long anNo) {
		this.anNo = anNo;
	}

	public Long getAnNo() {
		return anNo;
	}

	public void setAnNo(Long anNo) {
		this.anNo = anNo;
	}

	public String getAnTitle() {
		return anTitle;
	}

	public void setAnTitle(String anTitle) {
		this.anTitle = anTitle;
	}

	public String getAnContent() {
		return anContent;
	}

	public void setAnContent(String anContent) {
		this.anContent = anContent;
	}

	public String getAnType() {
		return anType;
	}

	public void setAnType(String anType) {
		this.anType = anType;
	}

	public String getAnEditor() {
		return anEditor;
	}

	public void setAnEditor(String anEditor) {
		this.anEditor = anEditor;
	}

	public Integer getAnDate() {
		return anDate;
	}

	public void setAnDate(Integer anDate) {
		this.anDate = anDate;
	}



}
