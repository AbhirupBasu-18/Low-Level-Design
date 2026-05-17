package com.abhirup.problems.parkinglot.exceptions;

public class InvalidTicketException extends Exception {
    public InvalidTicketException(String message) {
        super(message);
    }

    public InvalidTicketException(String message, Throwable cause) {
        super(message, cause);
    }
}
