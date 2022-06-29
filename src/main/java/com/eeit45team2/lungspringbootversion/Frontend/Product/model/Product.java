package com.eeit45team2.lungspringbootversion.Frontend.Product.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

@Entity
@Getter
@Setter
@ToString
@Table(name = "FrontProduct")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String title;
    private String item;
    private Double price;
    private Double discount;
    private Blob corverimage;
    private String fileName;
    private String productNo;
    private String category;
    private Integer stock;
    @Transient
    private Integer itemID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemID")
    private ItemBean itemBean;

    @Transient
    MultipartFile productImage;

    public Product(Integer productId, String title, String item, Double price, Double discount, Blob corverimage, String fileName, String productNo, String category, Integer stock, Integer itemID, ItemBean itemBean, MultipartFile productImage) {
        this.productId = productId;
        this.title = title;
        this.item = item;
        this.price = price;
        this.discount = discount;
        this.corverimage = corverimage;
        this.fileName = fileName;
        this.productNo = productNo;
        this.category = category;
        this.stock = stock;
        this.itemID = itemID;
        this.itemBean = itemBean;
        this.productImage = productImage;
    }

    public Product() {
    }
}
