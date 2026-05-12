package com.example.demo.service; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

   

	@Override
	 public void registerNewUser(UserEntity userToInsert) {
		Optional<UserEntity> deatailsFound = userRepository.findById(userToInsert.getUserId());
		if(deatailsFound.isPresent()) {
			throw new IllegalArgumentException("User with id already present : "+userToInsert.getUserId());
		}
		else {
			userRepository.save(userToInsert);
			System.out.println("Details Entered..");
		}
    }

	@Override
	 public List<UserEntity> getAllUsers() {
    	List<UserEntity> listOfUsers = new ArrayList<UserEntity>();
		Iterator<UserEntity> userIter = userRepository.findAll().iterator();
		while(userIter.hasNext()) {
			UserEntity newUser = userIter.next();
			listOfUsers.add(newUser);
		}
		return listOfUsers;
	}

	@Override
	 public UserEntity getUserById(Integer id) {
        return userRepository.findById(id)
        		.orElseThrow(() -> new NoSuchElementException("User with this id does not exists: " + id));
               
    }

	@Override
	 public void updateUserDetails(Integer id, UserEntity userDetails) {
    	Optional<UserEntity> detailsFound = userRepository.findById(id);//select
		if(detailsFound.isPresent()) {
			UserEntity detailsToUpdate = detailsFound.get(); //unpack it from the Optional's box 
			detailsToUpdate.setUserAccountNumber("70001234567978"); // change it as per the arguments 
			detailsToUpdate.setUserBankName("PUNB Bhandara"); // change it as per the arguments 
			detailsToUpdate.setUserBankIFSC("ABCD3498231");
			userRepository.save(detailsToUpdate); // fire the update query
			System.out.println("User details updated..");
		}
		else {
			System.out.println("Customer not found");
			throw new NoSuchElementException("User with this id does not exists:"+id);
		}
    }
	@Override
	 public void removeUserDetails(Integer id) {
    	Optional<UserEntity> detailsFound = userRepository.findById(id);//select
		if(detailsFound.isPresent()) {
			UserEntity detailsToDelete = detailsFound.get(); //unpack it from the Optional's box 
			detailsToDelete = detailsFound.get(); //unpack it from the Optional's box 
			userRepository.delete(detailsToDelete); // fire the update query
			System.out.println("User details deleted..");
		}
		else {
			System.out.println("Customer not found");
			throw new NoSuchElementException("Customer with this id does not exists:"+id);
		}
    }
}