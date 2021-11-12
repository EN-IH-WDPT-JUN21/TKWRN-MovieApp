package com.ironhack.gatewayservice.sampleData;

import com.ironhack.gatewayservice.dao.User;
import com.ironhack.gatewayservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public SampleDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(String... args) throws Exception {
//        this.userRepository.saveAll(List.of(new User("Ula", "admin", "ADMIN"),
//                new User("Adam", "user", "USER")));


    }
}
