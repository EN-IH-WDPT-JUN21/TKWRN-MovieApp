package com.ironhack.gatewayservice.Security;

import com.ironhack.gatewayservice.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.ArrayList;
import java.util.List;

//@EnableWebFluxSecurity
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   /* @Autowired
    private PasswordEncoder passwordEncoder;*/

    /*@Autowired
    private UserRepository userRepository;*/

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService);
                //.passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.httpBasic();
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers( "/api/authorities/**").hasRole("ADMIN")
                .antMatchers("/api/authorities**").hasRole("ADMIN")
                .antMatchers("/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    /*@Bean
    public MapReactiveUserDetailsService userDetailsService() {
        List<UserDetails> myUsers = new ArrayList<>();
        UserDetails user1 = User
                .withUsername("user")
                .password(passwordEncoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN")
                .build();
        myUsers.add(user1);
        myUsers.add(admin);
//        needs to load sample data before security
        this.userRepository.saveAll(List.of(new com.ironhack.gatewayservice.dao.User("Ula", "admin", "ADMIN"),
                new com.ironhack.gatewayservice.dao.User("Adam", "user", "USER")));
        List<com.ironhack.gatewayservice.dao.User> entities = userRepository.findAll();
        for(com.ironhack.gatewayservice.dao.User entity: entities){
        UserDetails user = User
                .withUsername(entity.getUsername())
                .password(passwordEncoder.encode(entity.getPassword()))
                .roles(entity.getRole())
                .build();
            myUsers.add(user);
        }
        System.out.println(myUsers);

        return new MapReactiveUserDetailsService(myUsers);
    }*/


}
