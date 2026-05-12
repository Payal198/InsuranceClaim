package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VehicleEntity;
@RestController
public interface VehicleController {

	 ResponseEntity<VehicleEntity> addVehicleDetails(VehicleEntity vehicleEntity);

	    // Method to get details of all vehicles
	    ResponseEntity<List<VehicleEntity>> getAllVehicleDetails();

	    // Method to get details of a single vehicle by ID
	    ResponseEntity<VehicleEntity> getVehicleDetails(int vehicleId);

	    // Method to update details of a vehicle by ID
	    ResponseEntity<VehicleEntity> updateVehicleDetails(int vehicleId, VehicleEntity vehicleEntity);

	    // Method to delete a vehicle by ID
	    ResponseEntity<Void> deleteVehicleDetails(int vehicleId);
	    
	    
	    
	    ResponseEntity<?> getAllDetails(int claimId,int insuranceId,int policyId,int userId,int vehicleId);
	    
}
