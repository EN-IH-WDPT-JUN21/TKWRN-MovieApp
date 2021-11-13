package com.ironhack.userservice.controller;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserReceiptDTO;
import com.ironhack.userservice.dto.UserRequestDTO;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/authorities")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    IUserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){

        return userService.getUsers();
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserByUsername (@PathVariable(name="username") String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public UserReceiptDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO){
        return userService.createUser(userRequestDTO);
    }


}
