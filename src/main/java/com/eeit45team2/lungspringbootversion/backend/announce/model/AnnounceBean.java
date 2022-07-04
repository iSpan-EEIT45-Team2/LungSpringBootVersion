package com.eeit45team2.lungspringbootversion.backend.announce.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

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
//	Date anDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	Date anDate;


	public AnnounceBean() {
	}

	public AnnounceBean(String anTitle, String anContent, String anType, String anEditor,
						 Date anDate) {
		super();
		this.anTitle = anTitle;
		this.anContent = anContent;
		this.anType = anType;
		this.anEditor = anEditor;
		this.anDate = anDate;
	}

	public AnnounceBean(Long anNo, String anTitle, String anContent, String anType, String anEditor,
						Date anDate) {
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

	public Date getAnDate() {
		return anDate;
	}

	public void setAnDate(Date anDate) {
		this.anDate = anDate;
	}



}
