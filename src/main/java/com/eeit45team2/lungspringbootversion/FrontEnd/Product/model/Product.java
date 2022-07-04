package com.eeit45team2.lungspringbootversion.FrontEnd.Product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@ToString
@Table(name = "Product_Table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pd_id;
    private String pd_product_name;
    private String pd_image;
    private String pd_content;
    private String pd_specification;
    private Integer pd_quantity;
    private Integer pd_amount;
    @CreationTimestamp
    private Timestamp admissionTime;

    public Product() {
    }

    public Product(Long pd_id, String pd_product_name, String pd_image, String pd_content, String pd_specification, Integer pd_quantity, Integer pd_amount, Timestamp admissionTime) {
        this.pd_id = pd_id;
        this.pd_product_name = pd_product_name;
        this.pd_image = pd_image;
        this.pd_content = pd_content;
        this.pd_specification = pd_specification;
        this.pd_quantity = pd_quantity;
        this.pd_amount = pd_amount;
        this.admissionTime = admissionTime;
    }

    public Product(String pd_product_name, String pd_image, String pd_content, String pd_specification, Integer pd_quantity, Integer pd_amount, Timestamp admissionTime) {
        this.pd_product_name = pd_product_name;
        this.pd_image = pd_image;
        this.pd_content = pd_content;
        this.pd_specification = pd_specification;
        this.pd_quantity = pd_quantity;
        this.pd_amount = pd_amount;
        this.admissionTime = admissionTime;
    }
}
