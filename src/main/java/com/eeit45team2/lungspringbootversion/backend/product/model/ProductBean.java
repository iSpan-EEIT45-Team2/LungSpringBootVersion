package com.eeit45team2.lungspringbootversion.backend.product.model;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;


@Entity
@Table(name = "Product_Table")
@Getter
@Setter
@ToString
public class ProductBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long pd_id;
	String pd_items;
	String pd_product_name;


	String localfileName;

	//Blob image;

//	@Transient
//	MultipartFile productImage;


	String pd_content;

	String pd_specification;
	Integer pd_quantity;
	Integer pd_amount;

	public ProductBean() {
	}

	public ProductBean(Long pd_id, String pd_items, String pd_product_name, String pd_content,
					   String pd_specification, Integer pd_quantity, Integer pd_amount) {
		super();

		this.pd_id = pd_id;
		this.pd_items = pd_items;
		this.pd_product_name = pd_product_name;
		this.pd_content = pd_content;
		this.pd_specification = pd_specification;
		this.pd_quantity = pd_quantity;
		this.pd_amount = pd_amount;
	}

	public ProductBean(String pd_items, String pd_product_name, String pd_content, String pd_specification,
					   Integer pd_quantity, Integer pd_amount) {
		super();
		this.pd_items = pd_items;
		this.pd_product_name = pd_product_name;
		this.pd_content = pd_content;
		this.pd_specification = pd_specification;
		this.pd_quantity = pd_quantity;
		this.pd_amount = pd_amount;
	}

	public String getLocalfileName() {
		return localfileName;
	}

	public void setLocalfileName(String localfileName) {

		this.localfileName = localfileName;
	}

}
