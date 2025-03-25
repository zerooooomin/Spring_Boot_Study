package com.example.Cookie.model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String name;
    private String password;

}
