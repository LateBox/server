package com.latebox.server.report;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Report {

    private @Id
    @GeneratedValue
    Long id;
    private int userId;
    private int restaurantId;
    private String reportContent;


    Report() {
    }

    public Report(int userId, int restaurantId, String reportContent) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.reportContent = reportContent;
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

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }


    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", restaurantId='" + restaurantId + '\'' +
                ", report=" + reportContent +
                '}';
    }

}