package com.ta.mieangke.Detail_Order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.ta.mieangke.Menu.Menu;



@Entity
@Table(name="Detail_Order")
public class Detail_Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    @NotEmpty(message = "Quantity is required")
    private String quantity;

    @Column
    @NotEmpty(message = "Total is required")
    private String total;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    public Detail_Order() {
    }

    public Detail_Order(int id, String quantity, String total, Menu menu) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.menu = menu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

}



