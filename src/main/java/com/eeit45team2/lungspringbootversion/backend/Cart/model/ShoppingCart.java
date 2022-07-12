package com.eeit45team2.lungspringbootversion.backend.Cart.model;

import com.eeit45team2.lungspringbootversion.backend.order.model.Order;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Transient
    private Double totalPrice;
    @Transient
    private int itemsNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<CartItem> items = new HashSet<CartItem>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Order order;
    private String sessionToken;

    public ShoppingCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalPrice() {
        Double sum = 0.0;
        for (CartItem item : this.items) {
            sum = sum + item.getProduct().getPd_amount() * item.getQuantity();
        }
        return sum;
    }

    public int getItemsNumber() {
        return this.items.size();
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((items == null) ? 0 : items.hashCode());
        result = prime * result + ((sessionToken == null) ? 0 : sessionToken.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ShoppingCart other = (ShoppingCart) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (items == null) {
            if (other.items != null)
                return false;
        } else if (!items.equals(other.items))
            return false;
        if (sessionToken == null) {
            if (other.sessionToken != null)
                return false;
        } else if (!sessionToken.equals(other.sessionToken))
            return false;
        return true;
    }

}
