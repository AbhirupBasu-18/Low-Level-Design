package com.abhirup.problems.parkinglot.strategy;

import com.abhirup.problems.parkinglot.entity.Floor;
import com.abhirup.problems.parkinglot.entity.ParkingSlot;
import com.abhirup.problems.parkinglot.entity.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FarthestStrategy implements  SlotFindingStrategy{
    @Override
    public ParkingSlot findFreeSlots(Vehicle vehicle, List<Floor> floors) {
        List<Floor> reversedFloors = new ArrayList<>(floors);
        Collections.reverse(reversedFloors);
        for (Floor floor : reversedFloors) {
            ParkingSlot spot = floor.findAvailableSpot(vehicle);
            if (spot!=null) {
                return spot;
            }
        }
        return null;
    }
}
