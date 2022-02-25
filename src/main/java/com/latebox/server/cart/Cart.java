package com.latebox.server.cart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart {

    private @Id
    @GeneratedValue
    Long id;
    private int userId;
    private int restaurantId;
    private int[] itemIdsList;


    Cart() {}

    public Cart(int userId, int restaurantId, int[] itemIdsList) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.itemIdsList = itemIdsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int id) {
        this.restaurantId = id;
    }

    public int[] getItemIdsList() {
        return itemIdsList;
    }

    public void setItemIdsList(int[] itemList) {
        this.itemIdsList = itemList;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", items='" + itemIdsList + '\'' +
                '}';
    }

}