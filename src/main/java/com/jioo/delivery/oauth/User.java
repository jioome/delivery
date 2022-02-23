package com.jioo.delivery.oauth;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String address;


    @Builder
    public User(Long id,String name, String email,  Role role,String phoneNumber,String address){
        this.id = id;
        this.name = name;
        this.email = email;

        this.role = role;

        this.phoneNumber = phoneNumber;
        this.address = address;
    }



    public User update(String name){
        this.name = name;
        return this;
    }



    public String getRoleKey(){
        return this.role.getKey();
    }
}