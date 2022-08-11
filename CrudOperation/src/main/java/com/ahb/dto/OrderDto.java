package com.ahb.dto;

public class OrderDto {

    private int id;
    private String itemName;
    private String orderDate;
    private int orderAmount;
    private String city;
    private String orderBy;

    public OrderDto(){}

    public OrderDto(int id, String itemName, String orderDate, int orderAmount, String city, String orderBy) {
        super();
        this.id = id;
        this.itemName = itemName;
        this.orderDate = orderDate;
        this.orderAmount = orderAmount;
        this.city = city;
        this.orderBy = orderBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
