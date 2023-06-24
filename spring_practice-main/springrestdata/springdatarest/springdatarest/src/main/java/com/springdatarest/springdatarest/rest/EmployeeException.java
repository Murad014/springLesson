package com.springdatarest.springdatarest.rest;

import com.springdatarest.springdatarest.entity.Employee;
import com.springdatarest.springdatarest.exception.EmployeeNotFound;
import com.springdatarest.springdatarest.response.EmployeeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeException {

    @ExceptionHandler
    public ResponseEntity<EmployeeResponse> exceptionHandler(EmployeeNotFound exception){
        EmployeeResponse response = new EmployeeResponse();

        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }





}
