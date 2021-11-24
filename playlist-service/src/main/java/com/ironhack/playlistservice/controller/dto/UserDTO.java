package com.ironhack.playlistservice.controller.dto;

public class UserDTO {

    private String avatarURL;
    private String username;
    private String email;
    private String password;
    private String bio;
    private String userType;

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(String username) {
        this.username = username;
    }
}
