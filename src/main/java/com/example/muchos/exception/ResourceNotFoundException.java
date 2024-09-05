package com.example.muchos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructor que acepta un mensaje personalizado
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);  // Llama al constructor de la clase RuntimeException
    }
}
