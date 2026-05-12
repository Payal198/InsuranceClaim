package com.example.demo.service;

import com.example.demo.entity.VehicleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public interface VehicleService {

	VehicleEntity addVehicleDetails(VehicleEntity vehicleEntity);

    // Get details of all vehicles
    List<VehicleEntity> getAllVehicleDetails();

    // Get details of a single vehicle by its ID
    Optional<VehicleEntity> getVehicleDetails(int vehicleId);

    // Update vehicle details (for example, if some fields need to be updated)
    VehicleEntity updateVehicleDetails(int vehicleId, VehicleEntity vehicleEntity);

    // Delete vehicle details by ID
    void deleteVehicleDetails(int vehicleId);
}
