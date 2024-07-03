package com.bankapplication.demo.BankApp.domain;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "bank_details")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankName;
    private double accountBalance;
    @Column(unique = true)
    private String accNumber;

    @OneToOne
    @JoinColumn(name="username", referencedColumnName = "username", nullable = false)
    private User user;

}
