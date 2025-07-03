package com.sample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex)
    {
        String message=ex.getMessage();
        ApiResponse response=new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleInvalidArguments(
            MethodArgumentNotValidException ex
    )
    {
        Map<String,String> errorList=new HashMap<>();
        ex.getBindingResult()
          .getFieldErrors()
                .forEach(error->
                        errorList.put(error.getField(),error.getDefaultMessage()));

        return new ResponseEntity<>(errorList,HttpStatus.BAD_REQUEST);

    }
}
