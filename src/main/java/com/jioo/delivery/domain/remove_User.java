//package com.jioo.delivery.domain;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "user_id")
//    private String userId;
//
//    private String address;
//
//    private String name;
//
//    @Column(name = "phone_number")
//    private String phoneNumber;
//
//    private Integer type;
//
//    public User() {
//
//    }
//
//    public User(Long id, String userId, String address, String name, String phoneNumber, Integer type) {
//        this.id = id;
//        this.userId = userId;
//        this.address = address;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.type = type;
//    }
//
//    public User(String userId, String address, String name, String phoneNumber, Integer type) {
//        this.userId = userId;
//        this.address = address;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.type = type;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//}
