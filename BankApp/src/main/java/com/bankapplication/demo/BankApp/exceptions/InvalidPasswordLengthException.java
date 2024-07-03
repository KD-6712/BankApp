package com.bankapplication.demo.BankApp.exceptions;

public class InvalidPasswordLengthException extends RuntimeException{
    public InvalidPasswordLengthException(String message){
        super(message);
    }
}
