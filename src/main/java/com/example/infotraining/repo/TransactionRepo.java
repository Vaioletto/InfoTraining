package com.example.infotraining.repo;
/*
 * @author: Vu Ngoc Sang
 * @Date: 19/09/2020
 * @Role: Intern
 */
import com.example.infotraining.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, String> {
}
