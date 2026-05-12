package com.example.demo;
 
import java.util.Iterator;

import java.util.Optional;
 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;



@SpringBootTest

public class UserRepositoryTestCases {
 
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void RegisterUserTest() {
		UserEntity user=new UserEntity();
		user.setUserId(1);;
		user.setUserName("Vaibhav");
		user.setUserEmailId("vaibhav12@gmail.com");;
		user.setUserPhoneNumber("7391968463");
		user.setUserAccountNumber("700030004597");
		user.setUserBankName("HDFC Bank Mumbai");
		user.setUserBankIFSC("ABCD01234567688");
		
		UserEntity user1=new UserEntity();
		user1.setUserId(2);;
		user1.setUserName("Chaitanya");
		user1.setUserEmailId("chaitu23@gmail.com");;
		user1.setUserPhoneNumber("8761968467");
		user1.setUserAccountNumber("700030004567");
		user1.setUserBankName("Axis Bank Mumbai");
		user1.setUserBankIFSC("ABCD0123456");
		
		UserEntity user2=new UserEntity();
		user2.setUserId(3);;
		user2.setUserName("Manthan");
		user2.setUserEmailId("manthan128@gmail.com");;
		user2.setUserPhoneNumber("9791968403");
		user2.setUserAccountNumber("700030004567");
		user2.setUserBankName("HSBC Bank Mumbai");
		user2.setUserBankIFSC("ABCD0123456");
		
		userRepository.save(user);
		userRepository.save(user1);
		userRepository.save(user2);
	}


 
	@Test
	void selectAllCustomerTest() {
		Iterable<UserEntity> iterable = userRepository.findAll();
		Iterator<UserEntity> iterator = iterable.iterator();
		while(iterator.hasNext()) {
			UserEntity c = iterator.next();
			System.out.println(c.getUserId()+" "+c.getUserName()+" "+c.getUserEmailId()+" "+c.getUserPhoneNumber()+" "+c.getUserAccountNumber()+" "+c.getUserBankName()+" "+c.getUserBankIFSC());
		}	 
 
	}
	@Test
	void selectUserTest() {
		Optional<UserEntity> box = userRepository.findById(2);
		if(box.isPresent()) {
			UserEntity c = box.get();
			System.out.println(c.getUserId()+" "+c.getUserName()+" "+c.getUserEmailId()+" "+c.getUserPhoneNumber()+" "+c.getUserAccountNumber()+" "+c.getUserBankName()+" "+c.getUserBankIFSC());
		}	 
 
 
	}
	@Test
	void updateCustomerTest() {
		Optional<UserEntity> box = userRepository.findById(2);
		if(box.isPresent()) {
			UserEntity c = box.get();
			System.out.println(c.getUserId()+" "+c.getUserName()+" "+c.getUserEmailId()+" "+c.getUserPhoneNumber()+" "+c.getUserAccountNumber()+" "+c.getUserBankName()+" "+c.getUserBankIFSC());
			c.setUserName("Montu");
			userRepository.save(c);
		}
 
	}
	@Test
	void deleteCustomerTest() {
		Optional<UserEntity> box = userRepository.findById(2);
		if(box.isPresent()) {
			UserEntity c = box.get();
			System.out.println(c.getUserId()+" "+c.getUserName()+" "+c.getUserEmailId()+" "+c.getUserPhoneNumber()+" "+c.getUserAccountNumber()+" "+c.getUserBankName()+" "+c.getUserBankIFSC());
			userRepository.delete(c);
		}
 
	}
}
 
 
