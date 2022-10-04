package com.springsecurity.oauth2.domain.dto;

import com.springsecurity.oauth2.domain.model.User;
import lombok.Getter;
import java.io.Serializable;


/**
 * Entity 클래스를 직렬화했을 시의 이슈 발생을 방지한 세션 저장 용 DTO
 */
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
