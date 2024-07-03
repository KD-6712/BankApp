package com.bankapplication.demo.BankApp.controller;
import com.bankapplication.demo.BankApp.dto.FundTransferDTO;
import com.bankapplication.demo.BankApp.services.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/fund")
public class FundTransferController {
    @Autowired
    FundTransferService fundTransferService;

//    @RequestMapping(path="/{username}/{password}/{beneficiary_acc_number}/{transfer_amount}")
//    public String fundTransfer(@PathVariable("username") String username,
//                               @PathVariable("password") String password,
//                               @PathVariable("beneficiary_acc_number")  String beneficiaryAccNumber,
//                               @PathVariable("transfer_amount") Long transferAmount){
//        System.out.println(username + password);
//        fundTransferService.fundTransfer(username, password, beneficiaryAccNumber, transferAmount);
//        return "Successfully transferred";
//    }
@PostMapping("/transfer")
public ResponseEntity<String> transferFunds(@RequestBody FundTransferDTO fundTransferDTO) {
    fundTransferService.fundTransfer(fundTransferDTO.getUsername(), fundTransferDTO.getPassword(), fundTransferDTO.getAccNumber(), fundTransferDTO.getTransferAmount());
    return ResponseEntity.ok("Transfer successful");
}
}
