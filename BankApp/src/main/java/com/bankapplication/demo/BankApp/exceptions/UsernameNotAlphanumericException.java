package com.bankapplication.demo.BankApp.exceptions;

public class UsernameNotAlphanumericException extends RuntimeException{
    public UsernameNotAlphanumericException(String message){
        super(message);
    }
}
