package com.springsecurity.oauth2.oauth.base.dto;

import com.springsecurity.oauth2.oauth.base.model.AuthUser;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(AuthUser authUser) {
        this.name = authUser.getName();
        this.email = authUser.getEmail();
        this.picture = authUser.getPicture();
    }
}
