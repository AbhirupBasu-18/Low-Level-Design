package com.abhirup.problems.parkinglot.entity;

import com.abhirup.problems.parkinglot.strategy.SlotFindingStrategy;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate {
    private Integer gateNumber;
    private static final int MAX_RETRY_ATTEMPTS = 3;

    public EntryGate(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Ticket park(Vehicle vehicle, SlotFindingStrategy strategy, ParkingBuilding building){
        System.out.println("Entering parking through gate number: " + gateNumber);
        
        int retryCount = 0;
        while (retryCount < MAX_RETRY_ATTEMPTS) {
            ParkingSlot parkingSlot = strategy.findFreeSlots(vehicle, building.getFloors());
            
            if (parkingSlot != null) {
                synchronized (parkingSlot) {  // Lock slot to prevent race condition
                    if (parkingSlot.parkVehicle(vehicle)) {
                        Ticket ticket = new Ticket(UUID.randomUUID(), LocalDateTime.now(), parkingSlot);
                        System.out.println("Vehicle " + vehicle.getVehicleNumber() + " parked successfully. Ticket: " + ticket.getTicketNumber());
                        return ticket;
                    }
                }
                retryCount++;
                System.out.println("Slot taken by another vehicle. Retry attempt: " + retryCount + "/" + MAX_RETRY_ATTEMPTS);
            } else {
                System.out.println("No parking slot available for vehicle type: " + vehicle.getVehicleType());
                return null;
            }
        }
        
        System.out.println("Failed to park vehicle " + vehicle.getVehicleNumber() + " after " + MAX_RETRY_ATTEMPTS + " attempts");
        return null;
    }
}
