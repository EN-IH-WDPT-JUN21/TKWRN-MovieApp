package com.ironhack.gatewayservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserReceiptDTO {
    private Long id;

    private String username;
    private String password;
    private String role;

    public UserReceiptDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;

        this.role = role;
    }

    public UserReceiptDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
