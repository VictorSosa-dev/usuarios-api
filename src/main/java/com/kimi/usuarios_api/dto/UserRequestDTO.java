package com.kimi.usuarios_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @Min(value = 18, message = "La edad debe ser mayor o igual a 18")
    private int age;

}