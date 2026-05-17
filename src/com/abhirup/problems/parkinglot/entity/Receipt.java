package com.abhirup.problems.parkinglot.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Receipt {
    private UUID receiptNumber;
    private Integer amountPaid;
    private LocalDateTime exitTime;

    public Receipt(UUID receiptNumber, Integer amountPaid, LocalDateTime exitTime) {
        this.receiptNumber = receiptNumber;
        this.amountPaid = amountPaid;
        this.exitTime = exitTime;
    }

    public UUID getReceiptNumber() {
        return receiptNumber;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptNumber=" + receiptNumber +
                ", amountPaid=" + amountPaid +
                ", exitTime=" + exitTime +
                '}';
    }
}
