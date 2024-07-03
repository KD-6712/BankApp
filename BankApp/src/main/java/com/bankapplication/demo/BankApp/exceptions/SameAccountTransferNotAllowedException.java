package com.bankapplication.demo.BankApp.exceptions;

public class SameAccountTransferNotAllowedException extends RuntimeException{
    public SameAccountTransferNotAllowedException(String message){
        super(message);
    }
}
