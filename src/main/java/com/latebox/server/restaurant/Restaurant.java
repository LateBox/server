package com.latebox.server.restaurant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Restaurant {

    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private String description;
    private String address;


    Restaurant() {
    }

    public Restaurant(String name, String description, String address) {
        this.name = name;
        this.description = description;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                '}';
    }

}