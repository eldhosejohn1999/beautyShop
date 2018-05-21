package com.devhopes.beautyshop.models;

import com.devhopes.beautyshop.enums.Booking_Status;
import lombok.*;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class BookingResponse {

    /**
     * Unique id of the booking response
     */
    @NonNull
    String id;

    /**
     * The id of the booking
     */
    @NonNull
    String bookingId;

    /**
     * Status of the booking made
     */
    @NonNull
    Booking_Status bookingStatus;

    /**
     * Reasons or remarks if any
     */
    String remarks;

}
