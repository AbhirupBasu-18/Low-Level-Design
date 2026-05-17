package com.abhirup.problems.parkinglot.strategy;

import com.abhirup.problems.parkinglot.entity.Floor;
import com.abhirup.problems.parkinglot.entity.ParkingSlot;
import com.abhirup.problems.parkinglot.entity.Vehicle;

import java.util.List;

public interface SlotFindingStrategy {
    ParkingSlot findFreeSlots(Vehicle vehicle, List<Floor> floors);
}
