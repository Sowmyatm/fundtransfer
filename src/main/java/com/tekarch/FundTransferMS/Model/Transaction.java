package com.tekarch.FundTransferMS.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;
    private String transactionType; // INTER_BANK or INTRA_BANK
    private LocalDateTime transactionTime;
    private String status;
}

