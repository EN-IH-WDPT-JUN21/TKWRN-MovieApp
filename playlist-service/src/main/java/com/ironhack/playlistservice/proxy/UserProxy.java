package com.ironhack.playlistservice.proxy;

import com.ironhack.playlistservice.controller.dto.UserReceiptDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("user-service")
public interface UserProxy {

    @GetMapping("/api/users/get/{id}")
    UserReceiptDTO getUser(@PathVariable(name = "id") long id);
}
