package com.insurance.controller;

import com.insurance.model.Claim;
import com.insurance.service.ClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping
    public ResponseEntity<Claim> submitClaim(@RequestBody Claim claim) {
        Claim processedClaim = claimService.processClaim(claim);
        return ResponseEntity.ok(processedClaim);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Claims API is running");
    }
}
