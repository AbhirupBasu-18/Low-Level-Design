package com.abhirup.problems.parkinglot;

import com.abhirup.problems.parkinglot.entity.*;
import com.abhirup.problems.parkinglot.entity.ParkingLot;
import com.abhirup.problems.parkinglot.enums.VehicleType;
import com.abhirup.problems.parkinglot.exceptions.InvalidTicketException;
import com.abhirup.problems.parkinglot.exceptions.PaymentException;
import com.abhirup.problems.parkinglot.payment.CashPayment;
import com.abhirup.problems.parkinglot.payment.UpiPayment;
import com.abhirup.problems.parkinglot.pricing.VariableStrategy;
import com.abhirup.problems.parkinglot.strategy.NearestStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot parkingLot = ParkingLot.getInstance();
        
        // Fixed: Different gate numbers
        EntryGate entryGate1 = new EntryGate(1);
        EntryGate entryGate2 = new EntryGate(2);
        ExitGate exitGate1 = new ExitGate(1);
        ExitGate exitGate2 = new ExitGate(2);
        
        parkingLot.addExitGate(exitGate1);
        parkingLot.addExitGate(exitGate2);
        parkingLot.addEntryGate(entryGate1);
        parkingLot.addEntryGate(entryGate2);
        parkingLot.setCostComputingStrategy(new VariableStrategy());
        parkingLot.setSlotFindingStrategy(new NearestStrategy());
        
        Floor floor1 = new Floor(1, new ArrayList<>(List.of(
                new ParkingSlot("1", false, VehicleType.TWO_WHEELER),
                new ParkingSlot("2", false, VehicleType.FOUR_WHEELER)
        )));
        
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(new Floor(2, new ArrayList<>(List.of(
                new ParkingSlot("1", false, VehicleType.TWO_WHEELER),
                new ParkingSlot("2", false, VehicleType.FOUR_WHEELER)
        ))));
        
        // Fixed: Use addParkingSlot instead of addSpot
        floor1.addParkingSlot(new ParkingSlot("3", false, VehicleType.TWO_WHEELER));
        
        Vehicle vehicle1 = new Vehicle("DL-01-AB-1234", VehicleType.FOUR_WHEELER);
        Vehicle vehicle2 = new Vehicle("DL-01-CD-5678", VehicleType.FOUR_WHEELER);
        
        Ticket ticket1 = parkingLot.park(vehicle1, entryGate1);
        Ticket ticket2 = parkingLot.park(vehicle2, entryGate2);
        
        System.out.println("\n=== PARKING INFO ===");
        System.out.println(ticket1);
        System.out.println(ticket2);
        //Thread.sleep(60000);
        // Fixed: Handle exceptions and null checks
        System.out.println("\n=== EXITING ===");
        if(ticket1 != null) {
            try {
                Receipt receipt1 = parkingLot.unPark(ticket1, exitGate1, new CashPayment());
                System.out.println(receipt1);
            } catch (InvalidTicketException | PaymentException e) {
                System.err.println("Error during exit for vehicle1: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to park vehicle1");
        }
        
        if(ticket2 != null) {
            try {
                Receipt receipt2 = parkingLot.unPark(ticket2, exitGate2, new UpiPayment());
                System.out.println(receipt2);
            } catch (InvalidTicketException | PaymentException e) {
                System.err.println("Error during exit for vehicle2: " + e.getMessage());
            }
        } else {
            System.err.println("Failed to park vehicle2");
        }
    }
}
