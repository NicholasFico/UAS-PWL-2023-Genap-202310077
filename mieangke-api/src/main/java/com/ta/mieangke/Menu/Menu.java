package com.ta.mieangke.Menu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @NotEmpty(message = "Name is required")
    private String name;

    @Column
    private String description;

    @Column(length = 20)
    @NotEmpty(message = "Harga is required")
    private String harga;

    @Column
    private String foto;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean is_active;

    

    public Menu() {
    }

    public Menu(int id, String name, String description, boolean is_active, String harga, String foto) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.is_active = is_active;
        this.harga = harga;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
