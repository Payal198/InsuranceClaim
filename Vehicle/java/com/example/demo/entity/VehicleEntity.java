package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Entity
@Table(name = "VEHICLE_ENTITY")
public class VehicleEntity {

    // Vehicle ID (Primary Key)
    @Id
    @NotNull(message = "Vehicle ID cannot be null")
   
    private Integer vehicleId;

    // Type of Vehicle
    @NotNull(message = "Type of Vehicle cannot be null")
    @Size(min = 2, max = 50, message = "Type of Vehicle should be between 2 and 50 characters")
    private String typeOfVehicle;

    // Vehicle Number
    @NotNull(message = "Vehicle Number cannot be null")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Vehicle Number must be alphanumeric")
    @Size(min = 5, max = 15, message = "Vehicle Number should be between 5 and 15 characters")
    private String vehicleNumber;

    // Vehicle Model Number
    @NotNull(message = "Vehicle Model Number cannot be null")
    @Size(min = 2, max = 50, message = "Vehicle Model Number should be between 2 and 50 characters")
    private String vehicleModelNo;

    // Vehicle Purchase Date 
    @NotNull(message = "Vehicle Purchase Date cannot be null")
    private LocalDate vehiclePurchaseDate;

    // Vehicle Purchase Price
    @NotNull(message = "Vehicle Purchase Price cannot be null")
    @Positive(message = "Vehicle Purchase Price must be a positive value")
    private Double vehiclePurchasePrice;

    
    
    // Getters and Setters
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleModelNo() {
        return vehicleModelNo;
    }

    public void setVehicleModelNo(String vehicleModelNo) {
        this.vehicleModelNo = vehicleModelNo;
    }

    public LocalDate getVehiclePurchaseDate() {
        return vehiclePurchaseDate;
    }

    public void setVehiclePurchaseDate(LocalDate vehiclePurchaseDate) {
        this.vehiclePurchaseDate = vehiclePurchaseDate;
    }

    public Double getVehiclePurchasePrice() {
        return vehiclePurchasePrice;
    }

    public void setVehiclePurchasePrice(Double vehiclePurchasePrice) {
        this.vehiclePurchasePrice = vehiclePurchasePrice;
    }
    @Override
    public String toString() {
        return 
                "vehicleId=" + vehicleId +
                ", typeOfVehicle='" + typeOfVehicle + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleModelNo='" + vehicleModelNo + '\'' +
                ", vehiclePurchaseDate=" + vehiclePurchaseDate +
                ", vehiclePurchasePrice=" + vehiclePurchasePrice 
                ;
    }

}
