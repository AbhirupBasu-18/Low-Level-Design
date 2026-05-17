package com.abhirup.problems.parkinglot.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingBuilding {
    private List<Floor> floors;
public ParkingBuilding(){
    this.floors=new ArrayList<>();
}
    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
    public void addFloor(Floor floor){
        floors.add(floor);
    }
    public void removeFloor(Floor floor){
        floors.remove(floor);
    }
}
