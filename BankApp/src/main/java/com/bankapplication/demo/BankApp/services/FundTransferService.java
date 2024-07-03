package com.bankapplication.demo.BankApp.services;
import com.bankapplication.demo.BankApp.domain.BankDetail;
import com.bankapplication.demo.BankApp.exceptions.InvalidCredentialsException;
import com.bankapplication.demo.BankApp.exceptions.NotEnoughFundsAvailableException;
import com.bankapplication.demo.BankApp.exceptions.SameAccountTransferNotAllowedException;
import com.bankapplication.demo.BankApp.exceptions.UsernameNotFoundException;
import com.bankapplication.demo.BankApp.repository.BankDetailsRepository;
import com.bankapplication.demo.BankApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundTransferService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BankDetailsRepository bankDetailsRepository;

    public void fundTransfer(String username, String password, String beneficiaryAccNumber, double transferAmount){

        if(userRepository.findById(username).isEmpty()){
            throw new UsernameNotFoundException("username not found");
        }

        if(!password.equals(userRepository.findById(username).get().getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }

        BankDetail senderBankDetails = bankDetailsRepository.findByUserUsername(username);
        BankDetail receiverBankDetails = bankDetailsRepository.findByAccNumber(beneficiaryAccNumber);

        if(senderBankDetails.getAccountBalance() < transferAmount){
            throw new NotEnoughFundsAvailableException("Not enough funds available");
        }

        if(senderBankDetails.getUser().getUsername().equals(receiverBankDetails.getUser().getUsername())){
            throw new SameAccountTransferNotAllowedException("You cannot transfer to your own account.");
        }

        senderBankDetails.setAccountBalance(senderBankDetails.getAccountBalance()-transferAmount);
        receiverBankDetails.setAccountBalance(receiverBankDetails.getAccountBalance()+transferAmount);

        bankDetailsRepository.save(senderBankDetails);
        bankDetailsRepository.save(receiverBankDetails);
    }
}
