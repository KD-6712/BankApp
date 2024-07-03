package com.bankapplication.demo.BankApp.exceptions;

public class NotEnoughFundsAvailableException extends RuntimeException{
    public NotEnoughFundsAvailableException(String message){
        super(message);
    }
}
