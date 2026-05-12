package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.VehicleEntity;

public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {

	List<VehicleEntity> findByTypeOfVehicle(String string);

	List<VehicleEntity> findByVehicleModelNoAndVehiclePurchasePrice(String string, double d);

	List<VehicleEntity> findByVehiclePurchaseDateAfter(LocalDate of);

}
