package com.bankapplication.demo.BankApp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDetailsDTO {
    private String bankName;
    private double accountBalance;
    private String accNumber;
}
