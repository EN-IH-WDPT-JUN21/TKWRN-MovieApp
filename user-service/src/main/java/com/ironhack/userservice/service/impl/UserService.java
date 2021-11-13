package com.ironhack.userservice.service.impl;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserReceiptDTO;
import com.ironhack.userservice.dto.UserRequestDTO;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.interfaces.IUserService;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;


    Logger logger = LoggerFactory.getLogger("UserService.class");

    @Retry(name = "user-api", fallbackMethod = "fallbackUserList")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Retry(name = "user-api", fallbackMethod = "fallbackUser")
    public User findUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        return optionalUser.isPresent()? optionalUser.get() : null;
    }

    @Retry(name = "user-api", fallbackMethod = "fallbackUserDTO")
    public UserReceiptDTO createUser(UserRequestDTO userRequestDTO) {
        try{
            User user;
            user = new User(userRequestDTO.getUsername(), userRequestDTO.getPassword(), userRequestDTO.getRole());
            userRepository.save(user);
            UserReceiptDTO userReceiptDTO = new UserReceiptDTO(user.getId(), user.getUsername(), user.getPassword(), user.getRole());
            return userReceiptDTO;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User type value not valid.");
        }
    }

    //fallback

    public List<User>  fallbackUserList(Exception e) {
        logger.info("call user fallback method");
        List<User> fallbackUserList = new ArrayList<>();
        User fallbackUser = new User("fallback", "fallback", "");
        fallbackUserList.add(fallbackUser);
        return fallbackUserList;
    }

    public User fallbackUser(Exception e) {
        logger.info("call user fallback method");
        User fallbackUser = new User("fallback", "fallback", "");
        return fallbackUser;
    }

    public UserReceiptDTO fallbackUserDTO(Exception e) {
        logger.info("call user fallback method");
        UserReceiptDTO fallbackUser = new UserReceiptDTO(1l, "fallback","fallback","");
        return fallbackUser;
    }
}
