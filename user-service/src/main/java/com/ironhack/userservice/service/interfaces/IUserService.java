package com.ironhack.userservice.service.interfaces;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserReceiptDTO;
import com.ironhack.userservice.dto.UserRequestDTO;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User findUserByUsername (String username);
    UserReceiptDTO createUser(UserRequestDTO userRequestDTO);
}
