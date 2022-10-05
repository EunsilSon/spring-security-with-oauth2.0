package com.springsecurity.oauth2.controller;

import com.springsecurity.oauth2.config.auth.LoginUser;
import com.springsecurity.oauth2.domain.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        // SessionUser user = (SessionUser)httpSession.getAttribute("user");
        // index 메서드 실행 시 @LoginUser 어노테이션으로 세션에 있는 로그인 유저 정보를 가져온다.

        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }
}
