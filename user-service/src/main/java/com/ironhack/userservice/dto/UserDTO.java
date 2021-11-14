package com.ironhack.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String userType;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
