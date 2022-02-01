package com.jioo.delivery.controller.request;
//객체 만들기

public class UserRequest {
    private String userId;
    private String name;
    private String address;
    private String phoneNumber;
    private int type;

    //디폴트 생성자를 명시적으로 만든다
    public UserRequest() {

    }

    public UserRequest(String userId, String name, String address, String phoneNumber, int type) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}