package com.example.Cookie.controller;

import com.example.Cookie.db.UserRepository;
import com.example.Cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest httpServletRequest,
            @CookieValue(name = "authorization-cookie",required = false)
            String authorizationCookie
    ) {
        log.info("authorizationCookie : {}", authorizationCookie);

        var optionalUserDto = userRepository.findByID(authorizationCookie);
        return optionalUserDto.get();

//        var cookies = httpServletRequest.getCookies();
//
//        if (cookies != null) {
//            for(Cookie cookie : cookies) {
//                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
//            }
//        }
    }
}
