package com.kimi.usuarios_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersDTO {
    
    @NotBlank(message = "El nombre debe ir vacio")
    private String name;
    @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
    private String age;
    private double totalAmount;

}
