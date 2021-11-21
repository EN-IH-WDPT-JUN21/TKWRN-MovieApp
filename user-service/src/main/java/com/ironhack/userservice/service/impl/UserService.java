package com.ironhack.userservice.service.impl;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserDTO;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;


    Logger logger = LoggerFactory.getLogger("UserService.class");

    //@Retry(name = "user-api", fallbackMethod = "fallbackUserList")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //@Retry(name = "user-api", fallbackMethod = "fallbackUser")
    public UserDTO findUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Username " + username + " not found!"));
        return convertUserToDTO(user);
    }

    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Username " + username + " not found!"));
        userRepository.delete(user);
    }

    public UserDTO updateUser(String username, UserDTO userDTO) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Username " + username + " not found!"));
        if (userDTO.getEmail() != null ) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getPassword() != null) {
            user.setPassword(userDTO.getPassword());
        }
        if (userDTO.getUserType() != null) {
            user.setUserType(userDTO.getUserType());
        }
        userRepository.save(user);
        return convertUserToDTO(user);
    }

    private UserDTO convertUserToDTO(User user) {
        return new UserDTO(user.getAvatarURL(), user.getUsername(), user.getEmail(), user.getPassword(), user.getUserType());
    }

    //fallback

   /* public List<User>  fallbackUserList(Exception e) {
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

    public UserDTO fallbackUserDTO(Exception e) {
        logger.info("call user fallback method");
        UserDTO fallbackUser = new UserDTO(1l, "fallback","fallback","");
        return fallbackUser;
    }*/
}
