package com.bankapplication.demo.BankApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferDTO {
    private String username;
    private String password;
    private String accNumber;
    private double transferAmount;
}
