package com.jioo.delivery.oauth;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

import java.util.Collection;

@Data
@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "user_id")
    private int userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String picture;


    @Builder
    public User(Long id, String name, String email, String picture, Role role, int userId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userId = userId;
        this.picture = picture;
        this.role = role;
    }

    @Builder
    public User(Long id, String name, String email, String picture, int userId) {
        super();
    }

    public User(String subject, String s, Collection<? extends GrantedAuthority> authorities) {
        super();
    }


    public User update(String name) {
        this.name = name;
        return this;
    }


    public String getRoleKey() {
        return this.role.getKey();
    }
}