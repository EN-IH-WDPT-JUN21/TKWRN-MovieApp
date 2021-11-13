package com.ironhack.gatewayservice.service.interfaces;

import com.ironhack.gatewayservice.dao.User;
import com.ironhack.gatewayservice.dto.UserReceiptDTO;
import com.ironhack.gatewayservice.dto.UserRequestDTO;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User findUserByUsername (String username);
    UserReceiptDTO createUser(UserRequestDTO userRequestDTO);
}
