package com.ironhack.gatewayservice.Security;

import com.ironhack.gatewayservice.dto.UserRequestDTO;
import com.ironhack.gatewayservice.proxy.UserServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class CustomUserDetails implements UserDetails {

    private UserRequestDTO userRequestDTO;

    @Autowired
    private UserServiceProxy userServiceProxy;

    public CustomUserDetails(UserRequestDTO userRequestDTO) {
        this.userRequestDTO = userRequestDTO;
    }

    //UserRequestDTO tempUser = userServiceProxy.findUserByUsername(userRequestDTO.getUsername());

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collection<GrantedAuthority> authorities = new HashSet<>();
        //var tempUser = userServiceProxy.findUserByUsername(userRequestDTO.getUsername());
        //for(UserRequestDTO user: userServiceProxy.findUserByUsername(userRequestDTO.getUsername())){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + userRequestDTO.getRole()));
        //}
        return authorities;
    }

    @Override
    public String getPassword(){
        return userRequestDTO.getPassword();
    }

    @Override
    public String getUsername(){
        return userRequestDTO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
