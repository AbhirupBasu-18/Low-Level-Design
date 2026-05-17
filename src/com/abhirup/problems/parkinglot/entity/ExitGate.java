package com.abhirup.problems.parkinglot.entity;

import com.abhirup.problems.parkinglot.exceptions.InvalidTicketException;
import com.abhirup.problems.parkinglot.exceptions.PaymentException;
import com.abhirup.problems.parkinglot.payment.PaymentType;
import com.abhirup.problems.parkinglot.pricing.CostComputingStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ExitGate {
    private Integer gateNumber;
    private static final long TICKET_VALIDITY_HOURS = 24;

    public ExitGate(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Receipt unPark(Ticket ticket, CostComputingStrategy costComputingStrategy, PaymentType paymentType)
            throws InvalidTicketException, PaymentException {
        
        // Validation 1: Null check
        if (ticket == null) {
            throw new InvalidTicketException("Ticket cannot be null");
        }
        

        
        // Validation 3: Check if vehicle is actually parked
        ParkingSlot slot = ticket.getParkingSlot();
        if (slot == null || !slot.isOccupied()) {
            throw new InvalidTicketException("Vehicle not found in this slot");
        }
        
        // Validation 4: Check ticket expiry
        if (isTicketExpired(ticket)) {
            throw new InvalidTicketException("Ticket expired. Valid for " + TICKET_VALIDITY_HOURS + " hours only");
        }

        synchronized (ticket){
            // Validation 2: Check if ticket already used
            if (ticket.isUsed()) {
                throw new InvalidTicketException("Ticket already used. Possible fraud!");
            }
            else{
                try {
                    System.out.println("Exiting through exit gate number: " + gateNumber);
                    // Calculate duration
                    long minutes = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toMinutes();
                    if (minutes < 0) {
                        throw new InvalidTicketException("Invalid ticket time");
                    }

                    Integer hours = Math.toIntExact((minutes + 59) / 60);
                    Integer cost = costComputingStrategy.amount(hours);

                    System.out.println("Parking duration: " + hours + " hours. Cost: " + cost);

                    // Process payment
                    if (!paymentType.pay(cost)) {
                        throw new PaymentException("Payment failed. Vehicle still parked.");
                    }

                    // Unpark vehicle after successful payment
                    slot.unparkVehicle();

                    // Mark ticket as used
                    ticket.setUsed(true);

                    Receipt receipt = new Receipt(UUID.randomUUID(), cost, LocalDateTime.now());
                    System.out.println("Exit successful. Receipt: " + receipt.getReceiptNumber());
                    return receipt;

                } catch (InvalidTicketException | PaymentException e) {
                    System.err.println("Error during exit: " + e.getMessage());
                    throw e;
                } catch (Exception e) {
                    System.err.println("Unexpected error during exit: " + e.getMessage());
                    throw new PaymentException("Exit failed: " + e.getMessage());
                }
            }
        }
    }
    
    private boolean isTicketExpired(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), LocalDateTime.now()).toHours();
        return hours >= TICKET_VALIDITY_HOURS;
    }
}
