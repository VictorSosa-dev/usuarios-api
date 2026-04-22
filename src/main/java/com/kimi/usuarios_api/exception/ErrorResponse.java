package com.kimi.usuarios_api.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponse {
    
    private String message;
    private int codigo;
    private LocalDateTime date;

    public ErrorResponse(String message, int codigo, LocalDateTime date) {
        this.message = message;
        this.codigo = codigo;
        this.date = date;
    }
}
