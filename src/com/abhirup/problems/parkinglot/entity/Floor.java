package com.abhirup.problems.parkinglot.entity;

import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;

    public Floor(int floorNumber, List<ParkingSlot> parkingSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    
    public void addParkingSlot(ParkingSlot parkingSlot) {
        if (parkingSlot != null) {
            this.parkingSlots.add(parkingSlot);
        }
    }
    
    public synchronized ParkingSlot findAvailableSpot(Vehicle vehicle){
        for(ParkingSlot parkingSlot:parkingSlots){
            if(parkingSlot.canFitVehicle(vehicle) && !parkingSlot.isOccupied()){
                return parkingSlot;
            }
        }
        return null;
    }
    
    public void removeSlot(ParkingSlot parkingSlot){
        if (parkingSlot != null) {
            parkingSlots.remove(parkingSlot);
        }
    }
}

