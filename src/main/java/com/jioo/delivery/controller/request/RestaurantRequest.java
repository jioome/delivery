package com.jioo.delivery.controller.request;
//객체 만들기

public class RestaurantRequest {
    private String name;
    private String address;
    private String callNumber;
    private Long ownerId;

    //디폴트 생성자를 명시적으로 만든다
    public RestaurantRequest() {

    }

    public RestaurantRequest(String name, String address, String call_number, Long ownerId) {
        this.name = name;
        this.address = address;
        this.callNumber = call_number;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}