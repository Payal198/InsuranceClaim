package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.InsuranceEntity;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.service.InsuranceServiceImplementation;


@SpringBootTest
class InsuranceServiceImplementationTest {

    @Mock
    private InsuranceRepository insuranceRepository;

    @InjectMocks
    private InsuranceServiceImplementation insuranceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testBuyInsuranceService() {
        // Arrange: Prepare input and mock behavior
        InsuranceEntity insurance = new InsuranceEntity();
        insurance.setInsuranceId(112);
        insurance.setInsuranceCoverageAmount(100000);
        insurance.setInsurancePremiumAmount(1000);
        insurance.setRenewalFrequency("Yearly");
        insurance.setIsactive(true); // The system sets this, so just for validation
        insurance.setInsuranceIssueDate(LocalDate.now());
        insurance.setInsuranceExpiryDate(LocalDate.now().plusYears(1));

        when(insuranceRepository.save(any(InsuranceEntity.class))).thenReturn(insurance);

        // Act: Call the method under test
        InsuranceEntity result = insuranceService.buyInsuranceService(insurance);

        // Assert: Verify results and interactions
        assertEquals(insurance.getInsuranceCoverageAmount(), result.getInsuranceCoverageAmount());
        assertEquals(insurance.getInsurancePremiumAmount(), result.getInsurancePremiumAmount());
        assertEquals(insurance.getInsuranceIssueDate(), result.getInsuranceIssueDate());
        assertEquals(insurance.getInsuranceExpiryDate(), result.getInsuranceExpiryDate());
        assertEquals(insurance.getRenewalFrequency(), result.getRenewalFrequency());
        assertEquals(insurance.getIsactive(), result.getIsactive());

        verify(insuranceRepository, times(1)).save(any(InsuranceEntity.class));
    }
}
