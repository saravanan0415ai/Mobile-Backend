package com.example.backend.config;

import com.example.backend.entity.User;
import com.example.backend.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                List<User> initialUsers = Arrays.asList(
                        createUser("gh@gmail.com", "123"),
                        createUser("hari1@gmail.com", "456"),
                        createUser("sa1@gmail.com", "456"),
                        createUser("saravanan0415@gmail.com", "123456"),
                        createUser("suresh@gmail.com", "123"),
                        createUser("siva23@gamil.com", "789456")
                );
                userRepository.saveAll(initialUsers);
                System.out.println("Inserted initial users from users.json to database.");
            }
        };
    }

    private User createUser(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole("user");
        return user;
    }
}
