package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.entity.InsuranceClaimEntity;
import com.example.demo.repository.InsuranceClaimRepository;
import com.example.demo.service.InsuranceClaimServiceInterface;
@SpringBootTest

public class InsuranceClaimServiceTest {
	@Autowired
    InsuranceClaimServiceInterface insuranceClaimServiceInterface;

    @Autowired
    InsuranceClaimRepository insuranceClaimRepository;

    @Autowired
    InsuranceClaimEntity claimEntity;

    // Test case for submitting a claim
    @Test
    void testSubmitClaim() {
        // Arrange: Creating a mock InsuranceClaimEntity object
        InsuranceClaimEntity claim = new InsuranceClaimEntity();
        claim.setClaimId(12);
        claim.setClaimAmount(5000.0);
        claim.setClaimStatus("Pending");
        claim.setAccidentSeverity("Moderate");
        claim.setAccidentReportNumber(12345);
        claim.setPolicyDeductible(1000.0);
        claim.setPolicyLimit(20000.0);
        claim.setSeverityMultiplier(1.5);
        claim.setClaimDate(LocalDate.of(2024, 5, 1));
        claim.setAccidentDate(LocalDate.of(2024, 4, 15));

        // Act: Call the submitClaim method to save the claim
        insuranceClaimServiceInterface.submitClaim(claim);
    }

    // Test case for retrieving all user claims
    @Test
    public void getAllUserClaimsTest() {
        // Act: Get all user claims from the service
        Iterable<InsuranceClaimEntity> claim = insuranceClaimServiceInterface.getAllUserClaims();

        // Output claim details (for debugging or visual verification)
        claim.forEach(i -> {
            System.out.println(i.getClaimId() + " " + i.getAccidentDate() + " " + i.getClaimDate() + " " +
                    i.getAccidentReportNumber() + " " + i.getClaimAmount() + " " + i.getClaimStatus() + " " +
                    i.getSeverityMultiplier() + " " + i.getPolicyDeductible() + " " + i.getPolicyLimit() + " " +
                    i.getAccidentSeverity());
        });
    }

    // Test case for retrieving claim details by ID
    @Test
    public void getClaimDetailsTest() {
        // Act: Retrieve claim details for claim ID 2
        InsuranceClaimEntity i = insuranceClaimServiceInterface.getClaimDetails(2);

        // Output claim details (for debugging or visual verification)
        System.out.println(i.getClaimId() + " " + i.getAccidentDate() + " " + i.getClaimDate() + " " +
                i.getAccidentReportNumber() + " " + i.getClaimAmount() + " " + i.getClaimStatus() + " " +
                i.getSeverityMultiplier() + " " + i.getPolicyDeductible() + " " + i.getPolicyLimit() + " " +
                i.getAccidentSeverity());
    }

    // Test case for updating the claim status by ID
    @Test
    public void updateClaimStatusTest() {
        // Act: Call the updateClaimStatus method for claim ID 3
        insuranceClaimServiceInterface.updateClaimStatus(3);
    }

    // Test case for calculating claim amount with Low severity
    @Test
    void testCalculateClaimAmount_LowSeverity() {
        // Arrange: Set up a claim entity with Low severity and other parameters
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(1000.0);  // Base claim amount
        claimEntity.setAccidentSeverity("Low");  // Low severity
        claimEntity.setPolicyDeductible(100.0);  // Deductible
        claimEntity.setPolicyLimit(1500.0);  // Policy limit

        // Act: Call the calculateClaimAmount method to calculate the final amount
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: Check if the calculated amount matches the expected result
        assertEquals(900.0, result, 0.01);  // Expected result after applying deductible
    }

    // Test case for calculating claim amount with Moderate severity
    @Test
    void testCalculateClaimAmount_ModerateSeverity() {
        // Arrange: Set up a claim entity with Moderate severity and other parameters
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(1000.0);  // Base claim amount
        claimEntity.setAccidentSeverity("Moderate");  // Moderate severity
        claimEntity.setPolicyDeductible(200.0);  // Deductible
        claimEntity.setPolicyLimit(1500.0);  // Policy limit

        // Act: Call the calculateClaimAmount method to calculate the final amount
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: Check if the calculated amount matches the expected result
        assertEquals(1300.0, result, 0.01);  // Expected result after applying severity multiplier and deductible
    }

    // Test case for calculating claim amount with High severity
    @Test
    void testCalculateClaimAmount_HighSeverity() {
        // Arrange: Set up a claim entity with High severity and other parameters
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(1000.0);  // Base claim amount
        claimEntity.setAccidentSeverity("High");  // High severity
        claimEntity.setPolicyDeductible(200.0);  // Deductible
        claimEntity.setPolicyLimit(2000.0);  // Policy limit

        // Act: Call the calculateClaimAmount method to calculate the final amount
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: Check if the calculated amount matches the expected result
        assertEquals(1800.0, result, 0.01);  // Expected result after applying severity multiplier and deductible
    }

    // Test case for calculating claim amount when it exceeds the policy limit
    @Test
    void testCalculateClaimAmount_ExceedsPolicyLimit() {
        // Arrange: Set up a claim entity where the claim amount exceeds the policy limit
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(2500.0);  // High claim amount
        claimEntity.setAccidentSeverity("Moderate");
        claimEntity.setPolicyDeductible(500.0);
        claimEntity.setPolicyLimit(2000.0);  // Policy limit

        // Act: Call the calculateClaimAmount method
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: Ensure that the result does not exceed the policy limit
        assertEquals(1500.0, result, 0.01);  // Result capped at the policy limit
    }

    // Test case for calculating claim amount with no deductible
    @Test
    void testCalculateClaimAmount_NoDeductible() {
        // Arrange: Set up a claim entity with no deductible
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(1000.0);  // Base claim amount
        claimEntity.setAccidentSeverity("Moderate");
        claimEntity.setPolicyDeductible(0.0);  // No deductible
        claimEntity.setPolicyLimit(1500.0);  // Policy limit

        // Act: Call the calculateClaimAmount method
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: The full claim amount should be returned as there is no deductible
        assertEquals(1500.0, result, 0.01);  // No deductible, should return the full claim amount
    }

    // Test case for calculating claim amount when the claim amount is zero
    @Test
    void testCalculateClaimAmount_ZeroClaimAmount() {
        // Arrange: Set up a claim entity with a zero claim amount
        claimEntity = new InsuranceClaimEntity();
        claimEntity.setClaimAmount(0.0);  // Zero claim amount
        claimEntity.setAccidentSeverity("High");
        claimEntity.setPolicyDeductible(0.0);
        claimEntity.setPolicyLimit(1000.0);

        // Act: Call the calculateClaimAmount method
        double result = insuranceClaimServiceInterface.calculateClaimAmount(claimEntity);

        // Output result (for debugging or verification)
        System.out.println(result);

        // Assert: A claim with zero amount should return zero
        assertEquals(0.0, result, 0.01);  // No claim amount, should return 0
    }
}