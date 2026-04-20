package com.abhirup.problems.parkinglot.entity;

import java.util.List;

public class Floor {
    private String floorId;
    private String floorName;
    private int floorNumber;
    private List<ParkingSlot> parkingSlots;
    //add parking slot here
    void addParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlots.add(parkingSlot);
    }
}

