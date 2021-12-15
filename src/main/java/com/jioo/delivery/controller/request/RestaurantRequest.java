package com.jioo.delivery.controller.request;
//객체 만들기

public class RestaurantRequest {
    private long id;
    private String name;
    private String address;
    private String call_number;
    private long owner_id;

    //디폴트 생성자를 명시적으로 만든다
    public RestaurantRequest() {

    }

    public RestaurantRequest(long id, String name, String address, String call_number, long owner_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.call_number = call_number;
        this.owner_id = owner_id;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCall_number() {
        return call_number;
    }

    public void setCall_number(String call_number) {
        this.call_number = call_number;
    }

    public long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(long owner_id) {
        this.owner_id = owner_id;
    }
}