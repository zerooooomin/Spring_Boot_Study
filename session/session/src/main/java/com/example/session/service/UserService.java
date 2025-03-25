package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionUser = userRepository.findByName(id);

        if (optionUser.isPresent()) {
            var userDTO = optionUser.get();

            if(userDTO.getPassword().equals(pw)) {
                // 세션에 정보 저장
                httpSession.setAttribute("USER", userDTO);

            }else {
                throw new RuntimeException("password not found");
            }

        }else{
            throw new RuntimeException("User not found");
        }
    }

}
