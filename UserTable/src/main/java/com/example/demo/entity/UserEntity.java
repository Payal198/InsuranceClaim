package com.example.demo.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="user_table")
public class UserEntity {
	
	@Id
	@NotNull
	private Integer userId;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String userName;
	
	@NotNull
	@Email
	private String userEmailId;
	
	@NotNull(message = "Phone number cannot be null")
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be between 10 and 15 digits long and may start with a '+' sign")
    private String userPhoneNumber;
	
	@NotNull(message = "Account number cannot be null")
    @NotBlank(message = "Account number cannot be empty")
    @Size(min = 8, max = 18, message = "Account number must be between 8 and 18 characters long")
    private String userAccountNumber;

	@NotNull(message = "Bank name cannot be null")
    @NotBlank(message = "Bank name cannot be empty")
    @Size(max = 100, message = "Bank name cannot exceed 100 characters")
    private String userBankName;

	@NotNull(message = "IFSC code cannot be null")
	@NotBlank(message = "IFSC code cannot be empty")  
	private String userBankIFSC;
		
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public String getUserBankName() {
		return userBankName;
	}
	public void setUserBankName(String userBankName) {
		this.userBankName = userBankName;
	}
	public String getUserBankIFSC() {
		return userBankIFSC;
	}
	public void setUserBankIFSC(String userBankIFSC) {
		this.userBankIFSC = userBankIFSC;
	}
	public UserEntity() {
		super();
		System.out.println("UserMaster() ctr...");
	}
	
	public void register() {
		System.out.println("User: User registration strated..");
	}
	
}





/*@OneToOne(mappedBy = "userEntity")
	UserLogin userLogin;//hasA, this is not a physical column
	
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}*/
