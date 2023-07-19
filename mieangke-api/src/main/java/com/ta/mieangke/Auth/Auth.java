package com.ta.mieangke.Auth;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "Auth")
public class Auth implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 50)
    @NotEmpty(message = "Nama is required")
    private String Nama;
    
    @Column(length = 20)
    private String No_Hp;

    @Column(length = 50)
    @NotEmpty(message = "Email is required")
    private String email;

    @Column(length = 50)
    @NotEmpty(message = "Password is required")
    private String password;


    public Auth() {
    }

    public Auth(int id, String email, String password, String Nama, String No_Hp) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.Nama = Nama;
        this.No_Hp = No_Hp;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getNo_Hp() {
        return No_Hp;
    }

    public void setNo_Hp(String no_Hp) {
        No_Hp = no_Hp;
    }

}
