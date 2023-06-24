package com.daocrud.daocrud.rest;

import com.daocrud.daocrud.exception.StudentNotFoundException;
import com.daocrud.daocrud.response.StudentNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentNotFound> exceptionResponse(StudentNotFoundException exception){
        StudentNotFound notFoundResponse = new StudentNotFound();
        notFoundResponse.setStatus(HttpStatus.NOT_FOUND.value());
        notFoundResponse.setMessage(exception.getMessage());
        notFoundResponse.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(notFoundResponse, HttpStatus.NOT_FOUND);
    }


}
