package com.API.Disney.exception;


import com.API.Disney.dto.errorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {


    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<errorDTO> runtimeExceptionHandler(RuntimeException e){
        errorDTO error = new errorDTO("p-401",e.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<errorDTO> requestExceptionHandler(RequestException ex){
        errorDTO error = new errorDTO(ex.getCode(), ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


    //mostrar los mensajes de error que me visualiza en la peticion y no el trace
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex){
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errorMessages= new ArrayList<>();

        for (FieldError fieldError: fieldErrors) {
            errorMessages.add(fieldError.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation error:[" + String.join(",\n", errorMessages +"]"));
    }


}
