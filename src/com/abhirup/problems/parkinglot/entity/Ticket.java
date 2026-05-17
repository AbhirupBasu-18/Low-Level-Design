package com.abhirup.problems.parkinglot.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ticket {
    private UUID ticketNumber;
    private LocalDateTime entryTime;
    private ParkingSlot parkingSlot;

    public void setUsed(boolean used) {
        isUsed = used;
    }

    private boolean isUsed = false;

    public UUID getTicketNumber() {
        return ticketNumber;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void markAsUsed() {
        this.isUsed = true;
    }

    public Ticket(UUID ticketNo, LocalDateTime entryTime, ParkingSlot parkingSlot) {
        this.ticketNumber = ticketNo;
        this.entryTime = entryTime;
        this.parkingSlot = parkingSlot;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", entryTime=" + entryTime +
                ", slotId=" + (parkingSlot != null ? parkingSlot.getSlotId() : "null") +
                ", isUsed=" + isUsed +
                '}';
    }
}
