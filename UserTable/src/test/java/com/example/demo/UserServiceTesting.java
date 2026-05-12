package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.UserEntity;

import com.example.demo.service.UserService;
@SpringBootTest
public class UserServiceTesting {

	@Autowired
	UserService userService;
	@Autowired
	UserEntity userEntity;
	@Test
	public void testUserDetails() {
		userEntity.setUserId(5);
		userEntity.setUserName("Mrunal");;
		userEntity.setUserEmailId("mru@gmail.com");
		userEntity.setUserPhoneNumber("7391966068");
		userEntity.setUserAccountNumber("700030001267");
		userEntity.setUserBankName("Axis Bank Mumbai");
		userEntity.setUserBankIFSC("ABCD0123456");
	
		userService.registerNewUser(userEntity);
	}
	@Test
	public void testModifyDetails() {
 
		userService.updateUserDetails(7, userEntity);;
	}
	
	@Test
	public void testDeleteDetails() {
 
		 userService.removeUserDetails(0);
	}
 
 
	@Test
	public void showAllUserServiceTest() {
		List<UserEntity>  user = userService.getAllUsers();
		for(UserEntity users : user) {
			System.out.println("User id    : "+users.getUserId());
			System.out.println("User Name  : "+users.getUserName());
			System.out.println("User EmailId : "+users.getUserEmailId());
			System.out.println("User PhoneNumber : "+users.getUserPhoneNumber());
			System.out.println("User Account Name : "+users.getUserAccountNumber());
			System.out.println("User's Bank Name : "+users.getUserBankName());
			System.out.println("Bank IFSC Code : "+users.getUserBankIFSC());
			System.out.println("-----------------------");
		}
	}
	@Test
	public void showSingleCustomerTest()
	{
		
		UserEntity users = userService.getUserById(1);
		
		System.out.println("User id    : "+users.getUserId());
    	System.out.println("User Name  : "+users.getUserName());
		System.out.println("User EmailId : "+users.getUserEmailId());
		System.out.println("User PhoneNumber : "+users.getUserPhoneNumber());
		System.out.println("User Account Name : "+users.getUserAccountNumber());
		System.out.println("User's Bank Name : "+users.getUserBankName());
		System.out.println("Bank IFSC Code : "+users.getUserBankIFSC());
		System.out.println("-----------------------");
		
	}
}