package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

@SpringBootTest
class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    void insertVehicleTest() {
        // Creating and saving a new vehicle
        VehicleEntity vehicle = new VehicleEntity();
        vehicle.setVehicleId(2);  // Use unique ID
        vehicle.setTypeOfVehicle("Car");
        vehicle.setVehicleNumber("HGG854");
        vehicle.setVehicleModelNo("GLA645");
        vehicle.setVehiclePurchaseDate(LocalDate.of(2024,9, 17));
        vehicle.setVehiclePurchasePrice(284400.00);
        vehicleRepository.save(vehicle);

        
    }

    @Test
    void selectAllVehiclesTest() {
        // Retrieving all vehicles from the repository
        Iterable<VehicleEntity> vehicles = vehicleRepository.findAll();
        Iterator<VehicleEntity> iterator = vehicles.iterator();
        
        // Printing all vehicle details
        System.out.println("All Vehicles:");
        while (iterator.hasNext()) {
            VehicleEntity v = iterator.next();
            System.out.println(v);
        }
    }

    @Test
    void selectVehicleByIdTest() {
        // Retrieving a specific vehicle by ID (should match the ID inserted above)
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(2);  // Use the correct ID
        if (vehicle.isPresent()) {
            System.out.println("Vehicle by ID 2: " + vehicle.get());
        } else {
            System.out.println("No vehicle found with ID 2");
        }
    }

    @Test
    void updateVehicleTest() {
        // Retrieving and updating a vehicle (make sure the ID matches)
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
    void deleteVehicleTest() {
        // Deleting a vehicle by ID
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(10);  // Use the correct ID
        if (vehicle.isPresent()) {
            vehicleRepository.delete(vehicle.get());
            System.out.println("Deleted Vehicle: " + vehicle.get());
        } else {
            System.out.println("Vehicle with ID  not found for deletion");
        }
    }

    @Test
    public void showVehiclesByTypeTest() {
        // Finding vehicles by type (e.g., "Car")
        List<VehicleEntity> vehicles = vehicleRepository.findByTypeOfVehicle("Bike");
        Assertions.assertTrue(vehicles != null && !vehicles.isEmpty());

        // Printing vehicle details
        System.out.println("Vehicles of Type 'Bike':");
        for (VehicleEntity v : vehicles) {
            System.out.println(v.getVehicleId() + " " + v.getVehicleNumber() + " " + v.getTypeOfVehicle());
        }
    }

    @Test
    public void showVehiclesByModelAndPriceTest() {
        // Finding vehicles by model number and purchase price
        List<VehicleEntity> vehicles = vehicleRepository.findByVehicleModelNoAndVehiclePurchasePrice("KWZ123", 78000.00);
        Assertions.assertTrue(vehicles != null && !vehicles.isEmpty());

        // Printing vehicle details
        
        for (VehicleEntity v : vehicles) {
            System.out.println(v.getVehicleId() + " " + v.getVehicleModelNo() + " " + v.getVehiclePurchasePrice());
        }
    }
    
    @Test
    public void showVehiclesByPurchaseDateTest() {
        // Finding vehicles purchased after a certain date
        List<VehicleEntity> vehicles = vehicleRepository.findByVehiclePurchaseDateAfter(LocalDate.of(2023, 12, 31));
        Assertions.assertTrue(vehicles != null && !vehicles.isEmpty());

        // Printing vehicle details
        System.out.println("Vehicles purchased after 2023-12-31:");
        for (VehicleEntity v : vehicles) {
            System.out.println(v.getVehicleId() + " " + v.getVehiclePurchaseDate());
        }
    }
}
