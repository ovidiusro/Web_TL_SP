package com.myfirstweb.Entity;

import javax.persistence.*;

@Entity
public class LineItem extends AbstractEntity{

    private double  price;
    private int     amount;

    @ManyToOne
    @JoinColumn
    private Orderr order;

    @ManyToOne
    public Product product;

    public LineItem(){}
    public Orderr getParent() { return order; }
    public void setParent(Orderr order) { this.order = order; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}
