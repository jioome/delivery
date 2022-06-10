package com.jioo.delivery.controller.request;
//객체 만들기

import com.jioo.delivery.oauth.User;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantRequest {
    private String name;
    private String address;
    private String callNumber;
    //디폴트 생성자를 명시적으로 만든다
    public RestaurantRequest() {

    }


    public RestaurantRequest(String name, String address, String callNumber) {
        this.name = name;
        this.address = address;
        this.callNumber = callNumber;
//        this.ownerId = ownerId;
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

}