package com.jioo.delivery.domain;

// ORM -> 자바 진영의 ORM 표준! Java Persistent API 패러다임 불일치

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String name;

    @Column(name = "call_number")
    private String callNumber;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;

    public Restaurant() {
    }

    public Restaurant(Long id, String address, String name, String callNumber, User user) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.callNumber = callNumber;
        this.user = user;
    }

    public Restaurant(String address, String name, String callNumber, User user) {
        this.address = address;
        this.name = name;
        this.callNumber = callNumber;
        this.user = user;
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

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
