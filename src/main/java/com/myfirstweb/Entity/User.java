package com.myfirstweb.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{


    private String username;
    private String password;

    @ManyToMany
    private List<Role> roles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Orderr> orderrs = new ArrayList<>();



    public List<Orderr> getOrderrs() { return orderrs; }
    public void addOrder(Orderr orderr) {
        this.orderrs.add(orderr);
        if (orderr.getUser() != this)
            orderr.setParent(this);
    }
    public void removeOrder(Orderr orderr)
    {
       this.orderrs.remove(orderr);
        orderr.setParent(null);
    }
    public Orderr getCurrentOrder(){
        if((orderrs.size() - 1) >= 0 )
        return orderrs.get(orderrs.size() - 1);
        else return  orderrs.get(0);
    } //retrive last orderr



    public User(){}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
