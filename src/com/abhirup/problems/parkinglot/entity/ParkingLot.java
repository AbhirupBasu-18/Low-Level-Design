package com.abhirup.problems.parkinglot.entity;

import com.abhirup.problems.parkinglot.exceptions.InvalidTicketException;
import com.abhirup.problems.parkinglot.exceptions.PaymentException;
import com.abhirup.problems.parkinglot.payment.PaymentType;
import com.abhirup.problems.parkinglot.pricing.CostComputingStrategy;
import com.abhirup.problems.parkinglot.pricing.FixedStrategy;
import com.abhirup.problems.parkinglot.strategy.NearestStrategy;
import com.abhirup.problems.parkinglot.strategy.SlotFindingStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private ParkingBuilding building;
    private SlotFindingStrategy slotFindingStrategy;
    private CostComputingStrategy costComputingStrategy;
    
    private ParkingLot(){
        this.exitGates=new ArrayList<>();
        this.entryGates=new ArrayList<>();
        this.building = new ParkingBuilding();
        
        // Set default strategies
        this.slotFindingStrategy = new NearestStrategy();
        this.costComputingStrategy = new FixedStrategy();
    }
    
    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }
    
    public Ticket park(Vehicle vehicle, EntryGate entryGate) {
        if (entryGate == null) {
            throw new IllegalArgumentException("Entry gate cannot be null");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null");
        }
        return entryGate.park(vehicle, slotFindingStrategy, building);
    }

    public Receipt unPark(Ticket ticket, ExitGate exitGate, PaymentType paymentType) 
            throws InvalidTicketException, PaymentException {
        if (exitGate == null) {
            throw new IllegalArgumentException("Exit gate cannot be null");
        }
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        if (paymentType == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }
        return exitGate.unPark(ticket, costComputingStrategy, paymentType);
    }

    public void setSlotFindingStrategy(SlotFindingStrategy slotFindingStrategy) {
        if (slotFindingStrategy == null) {
            throw new IllegalArgumentException("Slot finding strategy cannot be null");
        }
        this.slotFindingStrategy = slotFindingStrategy;
    }

    public void setCostComputingStrategy(CostComputingStrategy costComputingStrategy) {
        if (costComputingStrategy == null) {
            throw new IllegalArgumentException("Cost computing strategy cannot be null");
        }
        this.costComputingStrategy = costComputingStrategy;
    }
    
    public void addFloor(Floor floor) {
        if (floor == null) {
            throw new IllegalArgumentException("Floor cannot be null");
        }
        building.addFloor(floor);
    }

    public void setEntryGates(List<EntryGate> entryGates) {
        if (entryGates == null) {
            throw new IllegalArgumentException("Entry gates list cannot be null");
        }
        this.entryGates = entryGates;
    }

    public void setExitGates(List<ExitGate> exitGates) {
        if (exitGates == null) {
            throw new IllegalArgumentException("Exit gates list cannot be null");
        }
        this.exitGates = exitGates;
    }

    public void setBuilding(ParkingBuilding building) {
        if (building == null) {
            throw new IllegalArgumentException("Building cannot be null");
        }
        this.building = building;
    }
    
    public void addEntryGate(EntryGate gate) {
        if (gate == null) {
            throw new IllegalArgumentException("Entry gate cannot be null");
        }
        entryGates.add(gate);
    }
    
    public void addExitGate(ExitGate gate) {
        if (gate == null) {
            throw new IllegalArgumentException("Exit gate cannot be null");
        }
        exitGates.add(gate);
    }
    
    public void removeEntryGate(EntryGate gate) {
        if (gate == null) {
            throw new IllegalArgumentException("Entry gate cannot be null");
        }
        entryGates.remove(gate);
    }
    
    public void removeExitGate(ExitGate gate) {
        if (gate == null) {
            throw new IllegalArgumentException("Exit gate cannot be null");
        }
        exitGates.remove(gate);
    }
}
