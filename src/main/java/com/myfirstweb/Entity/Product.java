package com.myfirstweb.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Product extends AbstractEntity{

    private String name;
    private float price;
    private String photo;
    private Date   creationDate;
    private int     quantity;


    //public User getUser() { return user; }
    //public void setUser(User user) { this.user = user; }
    //@ManyToOne
    //@JoinColumn(name="OWNER_ID")
    //private User user;


    public Product( String name, float price, String photo, int quantity) {
        this.name = name;
        this.price = price;
        this.photo = photo;
        this.quantity = quantity;
        this.creationDate = new Date();
    }
    public Product(){ this.creationDate = new Date();}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creation) {
        this.creationDate = creation;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
