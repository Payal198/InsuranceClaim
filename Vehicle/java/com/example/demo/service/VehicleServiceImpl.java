package com.example.demo.service;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.myExceptions.DetailsNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public VehicleEntity addVehicleDetails(VehicleEntity vehicleEntity) {
        try {
            // Validate vehicle entity before saving
            if (vehicleEntity == null) {
                throw new IllegalArgumentException("Vehicle details cannot be null.");
            }

            // Saving vehicle details
            return vehicleRepository.save(vehicleEntity);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while adding vehicle details: " + e.getMessage(), e);
        }
    }

    @Override
    public List<VehicleEntity> getAllVehicleDetails() {
        try {
            List<VehicleEntity> vehicleList = new ArrayList<>();
            vehicleRepository.findAll().forEach(vehicleList::add);
            if (vehicleList.isEmpty()) {
                throw new DetailsNotFoundException("No vehicles found.");
            }
            return vehicleList;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching all vehicles: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<VehicleEntity> getVehicleDetails(int vehicleId) {
        try {
            Optional<VehicleEntity> vehicle = vehicleRepository.findById(vehicleId);
            if (!vehicle.isPresent()) {
                throw new DetailsNotFoundException("Vehicle with ID " + vehicleId + " not found.");
            }
            return vehicle;
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching vehicle details: " + e.getMessage(), e);
        }
    }

    @Override
    public VehicleEntity updateVehicleDetails(int vehicleId, VehicleEntity vehicleEntity) {
        try {
            if (vehicleEntity == null) {
                throw new IllegalArgumentException("Vehicle details cannot be null.");
            }

            if (!vehicleRepository.existsById(vehicleId)) {
                throw new DetailsNotFoundException("Vehicle with ID " + vehicleId + " does not exist.");
            }

            // Ensure the correct ID is set before saving
            vehicleEntity.setVehicleId(vehicleId);
            return vehicleRepository.save(vehicleEntity);
        } catch (DetailsNotFoundException e) {
            throw e; // Re-throw custom NotFoundException
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating vehicle details: " + e.getMessage(), e);
        }
    }

    @Override
    public void deleteVehicleDetails(int vehicleId) {
        try {
            if (!vehicleRepository.existsById(vehicleId)) {
                throw new DetailsNotFoundException("Vehicle with ID " + vehicleId + " does not exist.");
            }

            vehicleRepository.deleteById(vehicleId);
        } catch (DetailsNotFoundException e) {
            throw e; // Re-throw custom NotFoundException
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting vehicle details: " + e.getMessage(), e);
        }
    }
}
