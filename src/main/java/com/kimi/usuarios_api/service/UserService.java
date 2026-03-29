package com.kimi.usuarios_api.service;

import org.springframework.stereotype.Service;

import com.kimi.usuarios_api.dto.UsersDTO;
import com.kimi.usuarios_api.mapper.UserMapper;
import com.kimi.usuarios_api.model.Order;
import com.kimi.usuarios_api.model.User;
import com.kimi.usuarios_api.repository.UserRepository;

import lombok.RequiredArgsConstructor;


import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;


    public List<UsersDTO> obtenerUsersDTO() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<User> getOldUsers() {
        return repository.findAll()
                .stream()
                .filter(u -> u.getAge() >= 18)
                .collect(Collectors.toList());
    }

    public double OrderTotal() {
        return repository.findAll()
                .stream()
                .flatMap(u -> u.getOrders().stream())
                .mapToDouble(Order::getAmount)
                .sum();
    }

    public User getuserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User no encontrado"));
    }
}