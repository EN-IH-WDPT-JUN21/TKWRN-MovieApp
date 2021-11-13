package com.ironhack.gatewayservice.proxy;

import com.ironhack.gatewayservice.dto.UserReceiptDTO;
import com.ironhack.gatewayservice.dto.UserRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("user-service")
public interface UserServiceProxy {

    @GetMapping("/api/authorities")
    @ResponseStatus(HttpStatus.OK)
    List<UserRequestDTO> findAll();

    @GetMapping("/api/authorities/{username}")
    @ResponseStatus(HttpStatus.OK)
    UserRequestDTO findUserByUsername (@PathVariable(name="username") String username);

    @PostMapping("/api/authorities/new")
    @ResponseStatus(HttpStatus.CREATED)
    UserReceiptDTO createUser(@RequestBody @Valid UserRequestDTO userRequestDTO);
}
