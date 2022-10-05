package com.springsecurity.oauth2.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// 해당 파일 자체를 어노테이션으로 지정하려면 파일의 확장자 앞에 '@' 붙이기
public @interface LoginUser {

}
