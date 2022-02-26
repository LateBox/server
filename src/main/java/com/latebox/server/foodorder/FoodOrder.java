package com.latebox.server.foodorder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FoodOrder {

    private @Id
    @GeneratedValue
    Long id;
    private int userId;
    private int restaurantId;
    private int[] itemIdsList;
    private String timestamp;
    private String paymentMethod;
    private boolean pickedUp;


    FoodOrder() {}

    public FoodOrder(int userId, int restaurantId, int[] itemIdsList, String timestamp, String paymentMethod, boolean pickedUp) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.itemIdsList = itemIdsList;
        this.timestamp = timestamp;
        this.paymentMethod = paymentMethod;
        this.pickedUp = pickedUp;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(boolean pickedUp) {
        this.pickedUp = pickedUp;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", items='" + itemIdsList + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", pickedUp='" + pickedUp + '\'' +
                '}';
    }

}