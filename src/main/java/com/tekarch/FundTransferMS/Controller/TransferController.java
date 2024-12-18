package com.tekarch.FundTransferMS.Controller;

import com.tekarch.FundTransferMS.Model.TransferRequest;
import com.tekarch.FundTransferMS.Services.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    // 1. Endpoint: Process Fund Transfer
    @PostMapping
    public ResponseEntity<String> transferFunds(@Validated @RequestBody TransferRequest request) {
        String response = transferService.processTransfer(request);
        return ResponseEntity.ok(response);
    }

    // 2. Endpoint: Check if a transaction is within the limit
    @GetMapping("/check-limit")
    public ResponseEntity<Map<String, Object>> checkTransactionLimit(@RequestParam BigDecimal amount) {
        boolean withinLimit = transferService.isTransactionWithinLimit(amount);
        return ResponseEntity.ok(Map.of(
                "amount", amount,
                "withinLimit", withinLimit
        ));
    }

    // 3. Endpoint: Validate and get the maximum transaction limit
    @GetMapping("/transaction-limit")
    public ResponseEntity<Map<String, Object>> getTransactionLimit() {
        BigDecimal limit = transferService.getTransactionLimit();
        return ResponseEntity.ok(Map.of(
                "transactionLimit", limit
        ));
    }
}


