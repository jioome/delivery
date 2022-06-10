package com.jioo.delivery.oauth;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Collection;
import java.io.Serializable;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

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

    public Long getId() {
        return id;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
