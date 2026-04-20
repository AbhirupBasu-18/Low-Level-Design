package com.abhirup.problems.parkinglot;

import com.abhirup.problems.parkinglot.entity.EntryGate;
import com.abhirup.problems.parkinglot.entity.ExitGate;
import com.abhirup.problems.parkinglot.entity.ParkingBuilding;

import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private String parkingLotName;
    private String parkingLotAddress;
    private ParkingBuilding parkingBuilding;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;

     public ParkingLot(String parkingLotId, String parkingLotName, String parkingLotAddress, ParkingBuilding parkingBuilding, List<EntryGate> entryGates, List<ExitGate> exitGates) {
        this.parkingLotId = parkingLotId;
        this.parkingLotName = parkingLotName;
        this.parkingLotAddress = parkingLotAddress;
        this.parkingBuilding = parkingBuilding;
        this.entryGates = entryGates;
        this.exitGates = exitGates;
    }
    //entry method for vehicle
    //exit method for vehicle
    //add floor
    //add slots
}
