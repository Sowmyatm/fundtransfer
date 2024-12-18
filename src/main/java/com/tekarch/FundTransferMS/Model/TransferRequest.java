package com.tekarch.FundTransferMS.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

//import javax.persistence.*;
import java.time.LocalDateTime;

    @Data
    public class TransferRequest {
        @NotNull
        private String sourceAccountId;

        @NotNull
        private String destinationAccountId;

        @NotNull
        private BigDecimal amount;

        private boolean isIntraBank; // true for intra-bank, false for inter-bank
        private boolean isScheduled; // true for recurring/scheduled transfers
    }




//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long transferId;
//
//    @Column(name = "sender_account_id", nullable = false)
//    private String senderAccountId;
//
//    @Column(name = "receiver_account_id", nullable = false)
//    private String receiverAccountId;
//
//    private Double amount;
//
//    private String status;
//
//    @Column(name = "initiated_at")
//    private LocalDateTime initiatedAt;
//
//    @Column(name = "completed_at")
//    private LocalDateTime completedAt;
//}
