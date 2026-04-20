package com.abhirup.problems.parkinglot.entity;

import java.util.List;
import java.util.UUID;

public class ParkingBuilding {
    private UUID buildingId;
    private String buildingName;
    private List<Floor> floors;

     public ParkingBuilding(UUID buildingId, String buildingName, List<Floor> floors) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.floors = floors;
    }
    //add floor here
    void addFloor(Floor floor){
        this.floors.add(floor);
    }
}
