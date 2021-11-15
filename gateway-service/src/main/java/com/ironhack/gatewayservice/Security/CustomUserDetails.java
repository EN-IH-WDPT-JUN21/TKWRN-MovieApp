///*
//package com.ironhack.gatewayservice.Security;
//
//import com.ironhack.gatewayservice.dao.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.HashSet;
//
//public class CustomUserDetails implements UserDetails {
//    private User user;
//
//    public CustomUserDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities(){
//        Collection<GrantedAuthority> authorities = new HashSet<>();
////        for(User user: user.getRole()){
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
////        }
//        return authorities;
//    }
//
//    @Override
//    public String getPassword(){
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername(){
//        return user.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}
//*/
