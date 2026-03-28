package com.kimi.usuarios_api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kimi.usuarios_api.model.*;
import com.kimi.usuarios_api.repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner init(UserRepository repo) {
        return args -> {

            User u = new User();
            u.setName("Victor");
            u.setAge(25);

            Order o1 = new Order();
            o1.setAmount(100);
            o1.setDate(LocalDate.now());

            Order o2 = new Order();
            o2.setAmount(200);
            o2.setDate(LocalDate.now());

            u.setOrders(Arrays.asList(o1, o2));

            repo.save(u);
        };
    }
}
