package com.tekarch.FundTransferMS.Repositories;

import com.tekarch.FundTransferMS.Model.TransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tekarch.FundTransferMS.Model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

