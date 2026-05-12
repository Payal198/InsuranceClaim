package com.example.demo.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.model.Insurance;
import com.example.demo.model.InsuranceClaim;
import com.example.demo.model.Policy;
import com.example.demo.model.RequiredResponse;
import com.example.demo.model.User;
import com.example.demo.service.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicle")
public class VehicleControllerImpl implements VehicleController {

	 @Autowired
	  VehicleService vehicleService;
	 
	 @Autowired
	 RestTemplate restTemplate;

	    // 1. Add a new vehicle
	    @Override
	    @PostMapping("/add")
	    public ResponseEntity<VehicleEntity> addVehicleDetails(@Valid @RequestBody VehicleEntity vehicleEntity) {
	        VehicleEntity savedVehicle = vehicleService.addVehicleDetails(vehicleEntity);
	        return new ResponseEntity<>(savedVehicle, HttpStatus.CREATED);
	    }

	    // 2. Get details of all vehicles
	    @Override
	    @GetMapping("/all")
	    public ResponseEntity<List<VehicleEntity>> getAllVehicleDetails() {
	        List<VehicleEntity> vehicles = vehicleService.getAllVehicleDetails();
	        return new ResponseEntity<>(vehicles, HttpStatus.OK);
	    }

	    // 3. Get details of a single vehicle by ID
	    @Override
	    @GetMapping("/{vehicleId}")
	    public ResponseEntity<VehicleEntity> getVehicleDetails(@PathVariable int vehicleId) {
	        Optional<VehicleEntity> vehicle = vehicleService.getVehicleDetails(vehicleId);
	        return vehicle.map(v -> new ResponseEntity<>(v, HttpStatus.OK))
	                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    // 4. Update vehicle details by ID
	    @Override
	    @PutMapping("/{vehicleId}/update")
	    public ResponseEntity<VehicleEntity> updateVehicleDetails(
	            @PathVariable int vehicleId, 
	            @RequestBody VehicleEntity vehicleEntity) {
	        try {
	            VehicleEntity updatedVehicle = vehicleService.updateVehicleDetails(vehicleId, vehicleEntity);
	            return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    // 5. Delete a vehicle by ID
	    @Override
	    @DeleteMapping("/{vehicleId}/delete")
	    public ResponseEntity<Void> deleteVehicleDetails(@PathVariable int vehicleId) {
	        try {
	            vehicleService.deleteVehicleDetails(vehicleId);
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

		@Override
		@GetMapping("/getAllDetails/{vehicleId}/{userId}/{insuranceId}/{claimId}/{policyId}")
		public ResponseEntity<?> getAllDetails(@PathVariable int vehicleId,@PathVariable int userId, @PathVariable int insuranceId,@PathVariable int claimId, @PathVariable int policyId  ) {
			// TODO Auto-generated method stub
			RequiredResponse requiredResponse=new RequiredResponse();
			Optional<VehicleEntity> vehicleEntity=(vehicleService.getVehicleDetails(vehicleId));
			VehicleEntity vehicleFound=vehicleEntity.get();
			User user=restTemplate.getForObject("http://USER-SERVICE/api/users/"+userId, User.class);
			InsuranceClaim insuranceClaim=restTemplate.getForObject("http://INSURANCECLAIM-SERVICE/"+claimId, InsuranceClaim.class);
			Insurance insurance=restTemplate.getForObject("http://INSURANCE-SERVICE/api/insurance/insurance/ "+insuranceId, Insurance.class);
			Policy policy=restTemplate.getForObject("http://POLICY-SERVICE/policy/"+policyId, Policy.class);
			
			
			requiredResponse.setVehicle(vehicleFound);
			requiredResponse.setUser(user);
			requiredResponse.setInsurance(insurance);
			requiredResponse.setInsuranceClaim(insuranceClaim);
			requiredResponse.setPolicy(policy);
			
			
			return new ResponseEntity<>(requiredResponse,HttpStatus.OK);
			
			
			
		}
	}