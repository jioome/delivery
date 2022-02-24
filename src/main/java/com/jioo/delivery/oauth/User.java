package com.jioo.delivery.oauth;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email ;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.USER;

    private String picture;



    @Builder
    public User(int id,String name, String email, String picture ,Role role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    @Builder
    public User(int id, String name, String email, String picture) {
        super();
    }


    public User update(String name){
        this.name = name;
        return this;
    }



    public String getRoleKey(){
        return this.role.getKey();
    }
}