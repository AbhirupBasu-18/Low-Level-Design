package com.abhirup.problems.parkinglot.entity;

import com.abhirup.problems.parkinglot.enums.VehicleType;

public class ParkingSlot {
    private String slotId;
    private boolean isOccupied;
    private Vehicle parkedVehicle;
    private VehicleType slotType;

    public ParkingSlot(String slotId, boolean isOccupied, VehicleType slotType) {
        this.slotId = slotId;
        this.isOccupied = isOccupied;
        this.slotType = slotType;
    }

    public String getSlotId() {
        return slotId;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isOccupied) {
            return false;
        }
        if (!canFitVehicle(vehicle)) {
            System.out.println("Vehicle type mismatch. Expected: " + slotType + ", Got: " + vehicle.getVehicleType());
            return false;
        }
        this.isOccupied = true;
        this.parkedVehicle = vehicle;
        return true;
    }

    public synchronized void unparkVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        if (isOccupied) return false;
        return vehicle.getVehicleType().equals(slotType);
    }
}
