package com.tekarch.FundTransferMS.Services;

import com.tekarch.FundTransferMS.Model.TransferRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TransferService {

    private final RestTemplate restTemplate;

    @Value("${accounts.service.url}") // Load URL from properties
    private String accountsServiceUrl;

    public TransferService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Hardcoded transaction limit for demonstration
    private static final BigDecimal TRANSACTION_LIMIT = new BigDecimal("10000");

    public BigDecimal getTransactionLimit() {
        return TRANSACTION_LIMIT; // Return the transaction limit
    }

    public boolean isTransactionWithinLimit(BigDecimal amount) {
        return amount.compareTo(TRANSACTION_LIMIT) <= 0; // Check if amount <= limit
    }

    public boolean validateAccount(String accountId) {
        String url = accountsServiceUrl + "/api/accounts/" + accountId;

        try {
            Boolean isValid = restTemplate.getForObject(url, Boolean.class);
            return Boolean.TRUE.equals(isValid); // Avoid null pointer issues
        } catch (Exception e) {
            throw new RuntimeException("Error validating account: " + accountId, e);
        }
    }

    public String processTransfer(TransferRequest request) {
        // Business logic for processing the transfer
        return "Transfer processed successfully";
    }
}
//     Retrieve transaction limit
//    public BigDecimal getTransactionLimit() {
//        return TRANSACTION_LIMIT;
//    }

//    public BigDecimal getTransactionLimit() {
//    }



