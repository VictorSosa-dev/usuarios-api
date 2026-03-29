package com.kimi.usuarios_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kimi.usuarios_api.dto.UsersDTO;
import com.kimi.usuarios_api.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    @Mapping(target = "totalAmount", expression = "java(calculateTotalAmount(user))")
    UsersDTO toDTO(User user);

    default double calculateTotalAmount(User user) {
        return user.getOrders().stream()
            .mapToDouble(order -> order.getAmount())
            .sum();
    }
}
