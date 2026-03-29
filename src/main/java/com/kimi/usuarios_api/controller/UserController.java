package com.kimi.usuarios_api.controller;

import org.springframework.web.bind.annotation.*;

import com.kimi.usuarios_api.dto.UsersDTO;
import com.kimi.usuarios_api.model.User;
import com.kimi.usuarios_api.service.UserService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

     @GetMapping("/dto")
    public List<UsersDTO> getUsuariosDTO() {
        return service.obtenerUsersDTO();
    }

    @GetMapping("/mayores")
    public List<User> getMayores() {
        return service.getOldUsers();
    }

    @GetMapping("/total")
    public double total() {
        return service.OrderTotal();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getuserById(id);
    }
}
