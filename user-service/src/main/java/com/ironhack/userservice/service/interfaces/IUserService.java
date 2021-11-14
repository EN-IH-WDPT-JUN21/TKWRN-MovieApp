package com.ironhack.userservice.service.interfaces;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<User> getAllUsers();
    UserDTO findUserByUsername (String username);

    void deleteUser(String username);

    UserDTO updateUser(String username, UserDTO userDTO);

}
