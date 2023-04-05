package com.mecorp.mpphw.ExceptionHandlers;

import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
//public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler({ResourceNotFoundException.class})
//    public ResponseEntity<String> handleNotFoundException(Exception exception, WebRequest webRequest) {
//        return new ResponseEntity<>("Resource was not found", HttpStatus.NOT_FOUND);
//    }
//}
