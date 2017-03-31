package com.myfirstweb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Orderr extends AbstractEntity {

    @ManyToOne
    @JoinColumn
    public User user;

    private Date creationDate;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<LineItem> lineItems = new ArrayList<>();

    public Orderr() {}

    public boolean findProductById(long id) {
        for (LineItem line : lineItems) {
            if (line.getProduct().getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void deleteProductById(long id) {
        int i = 0;
        for (LineItem item : lineItems) {
            if (item.getProduct().getId() == id) {
                lineItems.remove(i);
                item.setParent(null);
                break;
            }
            i++;
        }
    }

    public void addLineItem(LineItem lineitem) {
        this.lineItems.add(lineitem);
        if(lineitem.getParent() != this)
            lineitem.setParent(this);
    }
    public  void removeLineItem(LineItem lineItem)
    {
       this.lineItems.remove(lineItem);
        lineItem.setParent(null);
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    public User getUser() {
        return user;
    }
    public void setParent(User user) {
        this.user = user;
    }
}