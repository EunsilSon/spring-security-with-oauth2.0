package com.springsecurity.oauth2.oauth.base.dao;

import com.springsecurity.oauth2.oauth.base.model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByEmail(String email);
}
