package com.ironhack.userservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String avatarURL;
    private String username;
    private String email;
    private String password;
    private String bio;
    @Column(name = "user_type")
    private String userType;


    public User(String avatarURL, String username, String email, String password, String bio, String userType) {
        this.avatarURL = avatarURL;
        this.username = username;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.userType = userType;
    }
}
