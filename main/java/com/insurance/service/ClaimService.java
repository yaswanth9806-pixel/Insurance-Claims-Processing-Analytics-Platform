package com.insurance.service;

import com.insurance.model.Claim;
import com.insurance.repository.ClaimRepository;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public Claim processClaim(Claim claim) {

        if (claim.getMemberId() == null || claim.getMemberId().trim().isEmpty()) {
            claim.setStatus("REJECTED");
            claim.setRejectionReason("Member ID is missing");
            return claim;
        }

        if (claim.getDiagnosisCode() == null || claim.getDiagnosisCode().trim().isEmpty()) {
            claim.setStatus("REJECTED");
            claim.setRejectionReason("Diagnosis code is missing");
            return claim;
        }

        if (claim.getAmount() == null || claim.getAmount() <= 0) {
            claim.setStatus("REJECTED");
            claim.setRejectionReason("Claim amount must be greater than zero");
            return claim;
        }

        boolean duplicateExists = claimRepository.existsByMemberIdAndDiagnosisCode(
                claim.getMemberId(),
                claim.getDiagnosisCode()
        );

        if (duplicateExists) {
            claim.setStatus("REJECTED");
            claim.setRejectionReason("Duplicate claim found for same member and diagnosis code");
            return claim;
        }

        claim.setStatus("APPROVED");
        claim.setRejectionReason(null);

        return claimRepository.save(claim);
    }
}
