package com.bankapplication.demo.BankApp.domain;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Column (length = 8)
    @Id
    private String username;

    @Column(nullable = false)
    private String password;
    private String address;
    private String mobile;
    private String email;
}
