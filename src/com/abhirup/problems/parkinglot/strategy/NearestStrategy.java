package com.abhirup.problems.parkinglot.strategy;

import com.abhirup.problems.parkinglot.entity.Floor;
import com.abhirup.problems.parkinglot.entity.ParkingSlot;
import com.abhirup.problems.parkinglot.entity.Vehicle;

import java.util.List;

public class NearestStrategy implements SlotFindingStrategy{
    @Override
    public ParkingSlot findFreeSlots(Vehicle vehicle, List<Floor> floors) {
        for (Floor floor : floors) {
            ParkingSlot spot = floor.findAvailableSpot(vehicle);
            if (spot!=null) {
                return spot;
            }
        }
        return null;
    }
}
