package com.jioo.delivery.controller.request;
//객체 만들기

import com.jioo.delivery.oauth.Role;

public class UserRequest {
    private Long id;
    private String name;
    private String email;
    private Role role;
    private String address;
    private String phoneNumber;



    //디폴트 생성자를 명시적으로 만든다
    public UserRequest() {

    }

    public UserRequest(Long id, String name, String email, Role role, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
}