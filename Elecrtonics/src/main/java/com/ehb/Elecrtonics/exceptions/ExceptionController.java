package com.ehb.Elecrtonics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = newException.class)
    public final ResponseEntity<String> handleException(newException exception)
    {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AuthenticationErrorException.class )
    public final ResponseEntity<String> handleAuthError(AuthenticationErrorException exception)
    {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = ProductErrorException.class )
    public final ResponseEntity<String> handleAuthError(ProductErrorException exception)
    {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);

    }
}
