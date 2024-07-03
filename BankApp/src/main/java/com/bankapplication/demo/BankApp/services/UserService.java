package com.bankapplication.demo.BankApp.services;
import com.bankapplication.demo.BankApp.domain.BankDetail;
import com.bankapplication.demo.BankApp.domain.User;
import com.bankapplication.demo.BankApp.dto.BankDetailsDTO;
import com.bankapplication.demo.BankApp.dto.UserAndBankDTO;
import com.bankapplication.demo.BankApp.dto.UserDTO;
import com.bankapplication.demo.BankApp.exceptions.*;
import com.bankapplication.demo.BankApp.repository.BankDetailsRepository;
import com.bankapplication.demo.BankApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BankDetailsRepository bankDetailsRepository;
    @Autowired
    private BankDetail bankDetail;

    public void registerUser(User user){
        System.out.println("Service");
        if(userRepository.findById(user.getUsername()).isPresent()){
            throw new DuplicateUsernameException("That username is taken. Try another.");
        }

        if(user.getPassword().length() < 6){
            throw new InvalidPasswordLengthException("The password should be 6 characters long.");
        }

        if(!isAlphaNumeric(user.getUsername())){
            throw new UsernameNotAlphanumericException("The username should be alphanumeric");
        }

        userRepository.save(user);
//        BankDetail bankDetail = new BankDetail();
        bankDetail.setBankName("HDFC");
        bankDetail.setAccountBalance(5000);
        bankDetail.setAccNumber(generateAccountNumber());
        bankDetail.setUser(user);
        bankDetailsRepository.save(bankDetail);
    }

    public UserAndBankDTO getUserDetails(String username, String password){

        if(userRepository.findById(username).isEmpty()){
            throw new UsernameNotFoundException("username not found");
        }

        if(!password.equals(userRepository.findById(username).get().getPassword())){
            throw new InvalidCredentialsException("Invalid credentials");
        }

        User user = userRepository.findById(username).get();
        BankDetail bankDetail = bankDetailsRepository.findByUserUsername(username);
        UserDTO userDTO = new UserDTO(user.getUsername(), user.getEmail(), user.getAddress(), user.getMobile());
        BankDetailsDTO bankDetailsDTO = new BankDetailsDTO(bankDetail.getBankName(), bankDetail.getAccountBalance(), bankDetail.getAccNumber());
        return new UserAndBankDTO(userDTO, bankDetailsDTO);
    }

    @Transactional
    public void deleteUser(String username){
        if(userRepository.findById(username).isEmpty()){
            throw new UsernameNotFoundException("username not found");
        }

//        if(!password.equals(userRepository.findById(username).get().getPassword())){
//            throw new InvalidCredentialsException("Invalid credentials");
//        }
        bankDetailsRepository.deleteByUser_Username(username);
        userRepository.deleteById(username);
    }

    private boolean isAlphaNumeric(String str) { return str != null && str.matches("^[a-zA-Z0-9]+$"); }
    private String generateAccountNumber() {
        String accNumberGen = String.valueOf(new Random().nextInt(900000000) + 1000000000);
//        while(accNumbers.contains(accNumberGen)){
//            accNumberGen = String.valueOf(new Random().nextInt(900000000) + 1000000000);
//        }
//        accNumbers.add(accNumberGen);
        return accNumberGen;
    }
}
