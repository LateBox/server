package com.latebox.server.review;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {

    private @Id
    @GeneratedValue
    Long id;
    private int userId;
    private int restaurantId;
    private int orderId;
    private int starRating;
    private String comments;
    private String date;


    Review() {
    }

    public Review(int userId, int restaurantId, int orderId, int starRating, String comments, String date) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.orderId = orderId;
        this.starRating = starRating;
        this.comments = comments;
        this.date = date;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", stars='" + starRating + '\'' +
                ", comments=" + comments +
                ", date=" + date +
                '}';
    }

}