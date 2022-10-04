package com.springsecurity.oauth2.config;

import com.springsecurity.oauth2.domain.model.Role;
import com.springsecurity.oauth2.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 화면 사용을 위해 해당 옵션들 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    // 권한 관리 대상 지정
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // ansMatchers로 설정된 url 외의 url 설정 => 로그인한 사용자들에게만 권한 부여
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공 시 괄호의 주소로 이동
                .and()
                    .oauth2Login()
                        .userInfoEndpoint() // 로그인 성공 후 사용자 정보 가져올 때 설정
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 이동
    }
}
