package com.jioo.delivery.domain;

// ORM -> 자바 진영의 ORM 표준! Java Persistent API 패러다임 불일치
public class Restaurant {
    Long id;
    String address;
    String name;

    public Restaurant(Long id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
