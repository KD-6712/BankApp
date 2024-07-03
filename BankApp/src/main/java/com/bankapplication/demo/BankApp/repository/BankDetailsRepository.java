package com.bankapplication.demo.BankApp.repository;
import com.bankapplication.demo.BankApp.domain.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetail, Long> {
    BankDetail findByUserUsername(String username);
    BankDetail findByAccNumber(String accNumber);
    @Transactional
    void deleteByUser_Username(String username);
}
