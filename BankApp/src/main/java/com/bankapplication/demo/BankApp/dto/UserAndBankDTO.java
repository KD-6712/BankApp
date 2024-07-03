package com.bankapplication.demo.BankApp.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAndBankDTO {
    private UserDTO userDetails;
    private BankDetailsDTO bankDetails;
}
