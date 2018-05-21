package com.devhopes.beautyshop.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
@Entity
public class Booking {

    /**
     * Unique id for a booking
     */
    @Id
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
    String customerId;

    /**
     * Date for which the customer needs to book the item
     */
    @NonNull
    Date dateForBooking;

    /**
     * The Slot number the customer needs to book
     */
    @NonNull
    String slotIdForBooking;
}
