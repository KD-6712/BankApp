package com.bankapplication.demo.BankApp.repository;

import com.bankapplication.demo.BankApp.domain.BankDetail;
import com.bankapplication.demo.BankApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
