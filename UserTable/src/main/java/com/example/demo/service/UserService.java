package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

@Service
public interface UserService {
	
	public void registerNewUser(UserEntity user);
	public List<UserEntity> getAllUsers();
	public UserEntity getUserById(Integer id);
	public void removeUserDetails(Integer id);
	public void updateUserDetails(Integer id, UserEntity userDetails);
}
