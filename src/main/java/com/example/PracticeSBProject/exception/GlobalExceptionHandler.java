package com.example.PracticeSBProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Exception Handling Method
    @ExceptionHandler({ResourceNotFoundException.class,IllegalArgumentException.class})
    public ResponseEntity<Map<String, Object>> handleIllegalArguementException(Exception e) {
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("message" ,e.getMessage());
        errorResponse.put("TimeStamp", LocalDateTime.now());
        errorResponse.put("status" , HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error","BAD REQUEST" );

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String,Object>> handleHttpRequestMethodNotSupportedException(Exception e)
    {
        Map<String,Object> errorResponse = new HashMap<>();
        errorResponse.put("message" ,e.getMessage());
        errorResponse.put("TimeStamp", LocalDateTime.now());
        errorResponse.put("status" , HttpStatus.METHOD_NOT_ALLOWED.value());
        errorResponse.put("error","METHOD NOT ALLOWED ON THIS ENDPOINT" );
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
