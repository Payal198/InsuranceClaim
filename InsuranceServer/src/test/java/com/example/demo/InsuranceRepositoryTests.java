package com.example.demo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.InsuranceEntity;
import com.example.demo.entity.PolicyEntity;
import com.example.demo.repository.InsuranceRepository;
import com.example.demo.repository.PolicyRepository;
import com.example.demo.service.InsuranceServiceInterface;

@SpringBootTest
public class InsuranceRepositoryTests {
	
	@Autowired 
	InsuranceRepository insuranRepository;
	
	@Autowired
	PolicyRepository policyRepository;
	
	
	@Test
	void insertInsuranceTest1() {
		InsuranceEntity insurance1 = new InsuranceEntity();
		insurance1.setInsuranceId(111);
		insurance1.setInsuranceIssueDate(LocalDate.now());
		insurance1.setInsuranceExpiryDate(LocalDate.now().plusYears(1));
		insurance1.setInsuranceCoverageAmount(100000);
		insurance1.setInsurancePremiumAmount(1000);
		insurance1.setRenewalFrequency("Yearly");
		insurance1.setIsactive(true);
		insurance1.setPolicyId(102);

		insuranRepository.save(insurance1);
		
	}
//		@Test
//		void insertInsuranceTest2() {
//			InsuranceEntity insurance1 = new InsuranceEntity();
//			insurance1.setInsuranceId(105);
//			insurance1.setInsuranceIssueDate(LocalDate.now());
//			insurance1.setInsuranceExpiryDate(LocalDate.now().plusYears(1));
//			insurance1.setInsuranceCoverageAmount(200000);
//			insurance1.setInsurancePremiumAmount(2000);
//			insurance1.setRenewalFrequency("Yearly");
//			insurance1.setIsactive(true);
//			insurance1.setPolicyId(102);
//
//			insuranRepository.save(insurance1);
//		}
//			
//			@Test
//			void insertInsuranceTest3() {
//				InsuranceEntity insurance1 = new InsuranceEntity();
//				insurance1.setInsuranceId(106);
//				insurance1.setInsuranceIssueDate(LocalDate.now());
//				insurance1.setInsuranceExpiryDate(LocalDate.now().plusYears(1));
//				insurance1.setInsuranceCoverageAmount(350000);
//				insurance1.setInsurancePremiumAmount(2500);
//				insurance1.setRenewalFrequency("Yearly");
//				insurance1.setIsactive(true);
//		        insurance1.setPolicyId(102);
//
//				insuranRepository.save(insurance1);
//		
//	}
	
}
