package com.devhopes.beautyshop.models;

import lombok.*;

import java.util.Date;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class Booking {

    /**
     * Unique id for a booking
     */
    String bookingId;

    /**
     * Item to book
     */
    @NonNull
    String itemId;

    /**
     * Customer details to contact
     */
    @NonNull
    Customer customer;

    /**
     * Date for which the customer needs to book the item
     */
    @NonNull
    Date dateForBooking;

    /**
     * The Slot number the customer needs to book
     */
    @NonNull
    Integer slotForBooking;
}
