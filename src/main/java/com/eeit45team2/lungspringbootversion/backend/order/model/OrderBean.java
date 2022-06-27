package com.eeit45team2.lungspringbootversion.backend.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Order_Table")
@Getter
@Setter
@ToString
public class OrderBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long od_id;
    String od_name;
    String od_catalogue;
    String od_content;
    String od_amount;
    Integer od_number;
    Integer od_money;

    public OrderBean() {
    }

    public OrderBean(String od_name, String od_catalogue, String od_content, String od_amount, Integer od_number,
                     Integer od_money) {
        super();
        this.od_name = od_name;
        this.od_catalogue = od_catalogue;
        this.od_content = od_content;
        this.od_amount = od_amount;
        this.od_number = od_number;
        this.od_money = od_money;
    }

    public OrderBean(Long od_id, String od_name, String od_catalogue, String od_content, String od_amount,
                     Integer od_number, Integer od_money) {
        super();
        this.od_id = od_id;
        this.od_name = od_name;
        this.od_catalogue = od_catalogue;
        this.od_content = od_content;
        this.od_amount = od_amount;
        this.od_number = od_number;
        this.od_money = od_money;
    }
	
}
