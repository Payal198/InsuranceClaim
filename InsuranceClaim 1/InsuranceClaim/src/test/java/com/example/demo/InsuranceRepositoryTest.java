package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.InsuranceClaimEntity;
import com.example.demo.repository.InsuranceClaimRepository;

@SpringBootTest
public class InsuranceRepositoryTest {
    
    @Autowired
    private InsuranceClaimRepository insuranceClaimRepository;

    /**
     * This method is used to set up the test data for the insurance claims repository.
     * It saves multiple InsuranceClaimEntity objects to the database to be used in various tests.
     */
    @Test
    public void setUp() {
        // Creating and saving various insurance claims with different details
        InsuranceClaimEntity testClaim = new InsuranceClaimEntity();     
        testClaim.setClaimId(1);      
        testClaim.setAccidentDate(LocalDate.of(2023, 5, 10));
        testClaim.setClaimDate(LocalDate.of(2023, 5, 12));
        testClaim.setAccidentReportNumber(12345);
        testClaim.setClaimAmount(15000.75f);
        testClaim.setClaimStatus("Pending");
        testClaim.setSeverityMultiplier(1.5);
        testClaim.setPolicyDeductible(500);
        testClaim.setPolicyLimit(20000);
        testClaim.setAccidentSeverity("low");
        insuranceClaimRepository.save(testClaim);

        // Additional test claims with different data
        // Each test claim is added to the database to be accessed by the test methods.
        InsuranceClaimEntity claim3 = new InsuranceClaimEntity();
        claim3.setClaimId(3);
        claim3.setAccidentDate(LocalDate.of(2023, 8, 5));
        claim3.setClaimDate(LocalDate.of(2023, 8, 7));
        claim3.setAccidentReportNumber(10345);
        claim3.setClaimAmount(7500.50);
        claim3.setClaimStatus("Pending");
        claim3.setSeverityMultiplier(1.4);
        claim3.setPolicyDeductible(700.00);
        claim3.setPolicyLimit(25000.00);
        claim3.setAccidentSeverity("Low");
        insuranceClaimRepository.save(claim3);
        
        InsuranceClaimEntity claim4 = new InsuranceClaimEntity();
        claim4.setClaimId(4);
        claim4.setAccidentDate(LocalDate.of(2023, 9, 15));
        claim4.setClaimDate(LocalDate.of(2023, 9, 16));
        claim4.setAccidentReportNumber(10456);
        claim4.setClaimAmount(10000.00);
        claim4.setClaimStatus("Approved");
        claim4.setSeverityMultiplier(1.5);
        claim4.setPolicyDeductible(300.00);
        claim4.setPolicyLimit(30000.00);
        claim4.setAccidentSeverity("Moderate");
        insuranceClaimRepository.save(claim4);
        
        // Saving more test claims to the repository for future tests
        // These help to test edge cases and repository queries
        InsuranceClaimEntity claim5 = new InsuranceClaimEntity();
        claim5.setClaimId(5);
        claim5.setAccidentDate(LocalDate.of(2023, 10, 10));
        claim5.setClaimDate(LocalDate.of(2023, 10, 12));
        claim5.setAccidentReportNumber(10567);
        claim5.setClaimAmount(12000.75);
        claim5.setClaimStatus("Pending");
        claim5.setSeverityMultiplier(2.0);
        claim5.setPolicyDeductible(1000.00);
        claim5.setPolicyLimit(40000.00);
        claim5.setAccidentSeverity("High");
        insuranceClaimRepository.save(claim5);
        
        // Additional claim added to the repository
        InsuranceClaimEntity claim6 = new InsuranceClaimEntity();
        claim6.setClaimId(6);
        claim6.setAccidentDate(LocalDate.of(2023, 11, 1));
        claim6.setClaimDate(LocalDate.of(2023, 11, 3));
        claim6.setAccidentReportNumber(10678);
        claim6.setClaimAmount(15000.00);
        claim6.setClaimStatus("Approved");
        claim6.setSeverityMultiplier(1.7);
        claim6.setPolicyDeductible(400.00);
        claim6.setPolicyLimit(35000.00);
        claim6.setAccidentSeverity("Moderate");
        insuranceClaimRepository.save(claim6);
        
        InsuranceClaimEntity claim7 = new InsuranceClaimEntity();
        claim7.setClaimId(7);
        claim7.setAccidentDate(LocalDate.of(2023, 7, 25));
        claim7.setClaimDate(LocalDate.of(2023, 7, 27));
        claim7.setAccidentReportNumber(10789);
        claim7.setClaimAmount(8000.00);
        claim7.setClaimStatus("Pending");
        claim7.setSeverityMultiplier(1.6);
        claim7.setPolicyDeductible(600.00);
        claim7.setPolicyLimit(20000.00);
        claim7.setAccidentSeverity("Moderate");
        insuranceClaimRepository.save(claim7);
    }

    /**
     * This test checks if all claims in the repository can be retrieved successfully.
     * It uses an iterator to loop through all claims and print their details.
     */
    @Test
    public  void getAllUserClaimsTest(){
    	Iterable<InsuranceClaimEntity> iterable = insuranceClaimRepository.findAll();
		Iterator<InsuranceClaimEntity> iterator = iterable.iterator();
		// Printing the details of each claim in the repository
		while(iterator.hasNext()) {
			InsuranceClaimEntity i = iterator.next();
			System.out.println(i.getClaimId() + " " + i.getAccidentDate() + " " + i.getClaimDate() + " " + 
                               i.getAccidentReportNumber() + " " + i.getClaimAmount() + " " + i.getClaimStatus() + " " + 
                               i.getSeverityMultiplier() + " " + i.getPolicyDeductible() + " " + i.getPolicyLimit() + " " + 
                               i.getAccidentSeverity());
		}
    }
    
    /**
     * This test checks if a specific claim can be retrieved by its ID.
     * It ensures the claim data is available and prints the details.
     */
    @Test
    public void getClaimDetailsTest() {
    	Optional<InsuranceClaimEntity> box = insuranceClaimRepository.findById(2);
    	
    	// If the claim exists, print its details
    	if(box.isPresent()) {
    		InsuranceClaimEntity i = box.get();
    		System.out.println(i.getClaimId() + " " + i.getAccidentDate() + " " + i.getClaimDate() + " " + 
                               i.getAccidentReportNumber() + " " + i.getClaimAmount() + " " + i.getClaimStatus() + " " + 
                               i.getSeverityMultiplier() + " " + i.getPolicyDeductible() + " " + i.getPolicyLimit() + " " + 
                               i.getAccidentSeverity());
    	}
    }

    /**
     * This test simulates updating the claim status of a specific claim.
     * It fetches a claim, modifies its status, and saves it back to the repository.
     */
    @Test
    public void updateClaimStatusTest() {
    	Optional<InsuranceClaimEntity> box = insuranceClaimRepository.findById(5);
    	
    	// If the claim exists, update its status to "Approved"
    	if(box.isPresent()) {
    		InsuranceClaimEntity i = box.get();
    		System.out.println(i.getClaimId() + " " + i.getAccidentDate() + " " + i.getClaimDate() + " " + 
                               i.getAccidentReportNumber() + " " + i.getClaimAmount() + " " + i.getClaimStatus() + " " + 
                               i.getSeverityMultiplier() + " " + i.getPolicyDeductible() + " " + i.getPolicyLimit() + " " + 
                               i.getAccidentSeverity());
    		i.setClaimStatus("Approved");
    		insuranceClaimRepository.save(i);  // Save the updated claim back to the repository
    	}
    }

    /**
     * This test checks the deletion functionality of a claim by its ID.
     * After deleting, it ensures the claim no longer exists in the repository.
     */
    @Test
    public void testDeleteInsuranceClaim() {
        insuranceClaimRepository.deleteById(2);
        Optional<InsuranceClaimEntity> deletedClaim = insuranceClaimRepository.findById(2);
        assertThat(deletedClaim).isNotPresent();  // Asserting that the claim has been deleted
    }
}
