package com.eeit45team2.lungspringbootversion.backend.product.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Table(name = "Product_Table")
@Getter
@Setter
@ToString
public class ProductBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pd_id;
    private String pd_items;
    private String pd_product_name;
    private String localfileName;
    //Blob image;

//	@Transient
//	MultipartFile productImage;


    private String pd_content;

    private String pd_specification;
    private Integer pd_quantity;
    private Integer pd_amount;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pd_id == null) ? 0 : pd_id.hashCode());
        result = prime * result + ((pd_product_name == null) ? 0 : pd_product_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ProductBean other = (ProductBean) obj;
        if (pd_id == null) {
            if (other.pd_id != null) {
                return false;
            }
        } else if (!pd_id.equals(other.pd_id)) {
            return false;
        }
        if (pd_product_name == null) {
            if (other.pd_product_name != null) {
                return false;
            }
        } else if (!pd_product_name.equals(other.pd_product_name)) {
            return false;
        }
        return true;
    }
}
