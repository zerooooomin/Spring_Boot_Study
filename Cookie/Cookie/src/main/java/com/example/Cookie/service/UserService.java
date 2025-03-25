package com.example.Cookie.service;

import com.example.Cookie.db.UserRepository;
import com.example.Cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //login logic
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                // cookie에 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setMaxAge(-1);
                cookie.setHttpOnly(true);
                cookie.setSecure(true); // https에서만 사용되도록 설정


                httpServletResponse.addCookie(cookie);
            }


        }else {
            throw new RuntimeException("User not found");
        }

    }

}
