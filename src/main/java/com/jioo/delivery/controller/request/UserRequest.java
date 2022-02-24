package com.jioo.delivery.controller.request;
//객체 만들기

import com.jioo.delivery.oauth.Role;

public class UserRequest {
    private int id;
    private String name;
    private String email;
    private Role role;
    private String picture;


    //디폴트 생성자를 명시적으로 만든다
    public UserRequest() {

    }

    public UserRequest(int id, String name, String email, Role role, String picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}