package com.ironhack.userservice.controller;

import com.ironhack.userservice.dao.User;
import com.ironhack.userservice.dto.UserDTO;
import com.ironhack.userservice.repository.UserRepository;
import com.ironhack.userservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    IUserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.)
    public UserDTO findUserByUsername (@PathVariable(name="username") String username){
        return userService.findUserByUsername(username);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user){
        return userRepository.save(user);
    }

    @PutMapping ("/update/{username}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable String username, @RequestBody UserDTO userDTO) {
        return userService.updateUser(username, userDTO);
    }

    @DeleteMapping("/delete/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
    }

}
