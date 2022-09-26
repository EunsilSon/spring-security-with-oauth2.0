package com.springsecurity.oauth2.oauth.base.model;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class BaseAuthUser extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BaseAuthRole role;

    @Builder
    public BaseAuthUser(String name, String email, String picture, BaseAuthRole role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public BaseAuthUser update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
