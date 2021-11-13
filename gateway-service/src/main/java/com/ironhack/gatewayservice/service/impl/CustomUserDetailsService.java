package com.ironhack.gatewayservice.service.impl;

import com.ironhack.gatewayservice.Security.CustomUserDetails;
import com.ironhack.gatewayservice.dto.UserRequestDTO;
import com.ironhack.gatewayservice.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceProxy userServiceProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserRequestDTO user = userServiceProxy.findUserByUsername(username);
            return new CustomUserDetails(user);

        } catch (UsernameNotFoundException e){

            throw new UsernameNotFoundException("User not found with username " + username);
        }

    }


}
