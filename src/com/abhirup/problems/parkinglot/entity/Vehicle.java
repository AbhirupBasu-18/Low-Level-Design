package com.abhirup.problems.parkinglot.entity;

import com.abhirup.problems.parkinglot.enums.VehicleType;

import java.util.UUID;
public class Vehicle {
    private UUID vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(UUID vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public UUID getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(UUID vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
