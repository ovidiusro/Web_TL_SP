package com.myfirstweb.Entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Role extends AbstractEntity{
    private String name;


    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {}
    public Role(String name) { this.name = name; }

    public List<User> getUsers() { return users; }
    public void setUsers(List<User> users) { this.users = users; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
