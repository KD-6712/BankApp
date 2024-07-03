package com.bankapplication.demo.BankApp.controller;
import com.bankapplication.demo.BankApp.domain.User;
import com.bankapplication.demo.BankApp.dto.UserAndBankDTO;
import com.bankapplication.demo.BankApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/bank")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        userService.registerUser(user);
        return ResponseEntity.ok("Registration successful");
    }

    @GetMapping(path = "/user")
    public ResponseEntity<UserAndBankDTO> getUserDetails(@RequestParam String username, @RequestParam String password){
        return new ResponseEntity<>(userService.getUserDetails(username, password), HttpStatus.OK);
    }

    @DeleteMapping(path = "delete/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        return new ResponseEntity<>("Deletion completed successfully", HttpStatus.OK);
    }
}
