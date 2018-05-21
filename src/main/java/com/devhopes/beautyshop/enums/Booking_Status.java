package com.devhopes.beautyshop.enums;

public enum Booking_Status {
    BOOKED("Booking successful"),
    BOOKED_NEEDS_CONFIRMATION("We have received your request, we will be contacting you through phone for confirmation"),
    PENDING("Booking is pending, we will contact you through phone"),
    FAILED("Failed to book"),
    CANCELLED("Booking canceled");

    public String value;

    Booking_Status(String value) {
        this.value = value;
    }
}
