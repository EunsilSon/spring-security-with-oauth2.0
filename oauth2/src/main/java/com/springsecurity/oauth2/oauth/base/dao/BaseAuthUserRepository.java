package com.springsecurity.oauth2.oauth.base.dao;

import com.springsecurity.oauth2.oauth.base.model.BaseAuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseAuthUserRepository extends JpaRepository<BaseAuthUser, Long> {

    Optional<BaseAuthUser> findByEmail(String email);
}
