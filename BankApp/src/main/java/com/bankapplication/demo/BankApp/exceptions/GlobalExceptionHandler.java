package com.bankapplication.demo.BankApp.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity<String> handleDuplicateUsernameException(DuplicateUsernameException e){
        return new ResponseEntity<>("A runtime exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotAlphanumericException.class)
    public ResponseEntity<String> handleUsernameNotAlphanumericException(UsernameNotAlphanumericException e){
        return new ResponseEntity<>("A runtime exception occurred: " + e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(InvalidPasswordLengthException.class)
    public ResponseEntity<String> handleInvalidPasswordLengthException(InvalidPasswordLengthException e){
        return new ResponseEntity<>("A runtime exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException e){
        return new ResponseEntity<>("A runtime exception occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException e){
        return new ResponseEntity<>("Runtime Exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotEnoughFundsAvailableException.class)
    public ResponseEntity<String> handleNotEnoughFundsAvailableException(NotEnoughFundsAvailableException e){
        return new ResponseEntity<>("Runtime Exception occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SameAccountTransferNotAllowedException.class)
    public ResponseEntity<String> handleSameAccountTransferNotAllowedException(SameAccountTransferNotAllowedException e){
        return new ResponseEntity<>("Runtime Exception occured: " + e.getMessage(), HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception e){
        return new ResponseEntity<>("System Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
