package com.example.demo;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import com.example.demo.service.VehicleServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VehicleServiceTest {
	@Autowired
    private VehicleService vehicleService; // Use the actual service class

    @Autowired
    private VehicleRepository vehicleRepository; // Use the actual repository

    private VehicleEntity vehicleEntity;

    

    @Test
    void testAddVehicleDetails() {
    	vehicleEntity = new VehicleEntity();
        vehicleEntity.setVehicleId(1);
        vehicleEntity.setTypeOfVehicle("Car");
        vehicleEntity.setVehicleNumber("ABC123");
        vehicleEntity.setVehicleModelNo("ModelX");
        vehicleEntity.setVehiclePurchaseDate(LocalDate.now());
        vehicleEntity.setVehiclePurchasePrice(15000.00);
        vehicleService.addVehicleDetails(vehicleEntity);
    }

    @Test
    void testGetAllVehicleDetails() {
    	 List<VehicleEntity> vehicles = vehicleService.getAllVehicleDetails();
         Assertions.assertTrue(vehicles != null && !vehicles.isEmpty());

         for (VehicleEntity v : vehicles) {
             System.out.println(v.getVehicleId() + " " + v.getVehicleNumber() + " " + v.getTypeOfVehicle());
         }
    }

    @Test
    void testGetVehicleDetails() {
    	 Optional<VehicleEntity> v = vehicleService.getVehicleDetails(12);

    	    // Check if the vehicle is present
    	    if (v.isPresent()) {
    	        // Print details of the vehicle
    	        VehicleEntity vehicle = v.get();
    	        System.out.println(vehicle.getVehicleId() + " " + vehicle.getVehicleNumber() + " " + vehicle.getTypeOfVehicle());
    	    } else {
    	        System.out.println("Vehicle not found!");
    	    }
       
    }

    @Test
    void testUpdateVehicleDetails() {
    	 Optional<VehicleEntity> vehicle = vehicleRepository.findById(2);  // Use the correct ID
         if (vehicle.isPresent()) {
             VehicleEntity v = vehicle.get();
             v.setVehicleNumber("MUM987");
             vehicleRepository.save(v);
             System.out.println("Updated Vehicle: " + v);
         } else {
             System.out.println("Vehicle with ID 2 not found for update");
         }
    }

    @Test
    void testDeleteVehicleDetails() {
    	Optional<VehicleEntity> vehicle = vehicleRepository.findById(10);  // Use the correct ID
        if (vehicle.isPresent()) {
            vehicleRepository.delete(vehicle.get());
            System.out.println("Deleted Vehicle: " + vehicle.get());
        } else {
            System.out.println("Vehicle with ID  not found for deletion");
        }
    }
}