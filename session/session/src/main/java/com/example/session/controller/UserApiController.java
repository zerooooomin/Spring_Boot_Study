package com.example.session.controller;


import com.example.session.model.UserDTO;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public UserDTO me(
            HttpSession httpSession
    ){
        var userObject = httpSession.getAttribute("USER");

        if (userObject != null ){
            var userDTO = (UserDTO) userObject;
            return userDTO;
        }
        else {
            return null;
        }

    }
}
