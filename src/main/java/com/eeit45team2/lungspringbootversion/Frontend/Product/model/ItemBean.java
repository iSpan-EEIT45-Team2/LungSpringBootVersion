package com.eeit45team2.lungspringbootversion.Frontend.Product.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "ProductItem")
public class ItemBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;
    private String itemName;
    @OneToMany(mappedBy = "itemBean")
    private Set<Product> products = new LinkedHashSet<>();

    public ItemBean(Integer itemId, String itemName, Set<Product> products) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.products = products;
    }

    public ItemBean() {
    }
}
