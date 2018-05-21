package com.devhopes.beautyshop.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
public class BookingResponse {

    /**
     * Unique id of the booking response
     */
    @NonNull
    @Id
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
    String bookingStatus;

    /**
     * Reasons or remarks if any
     */
    String remarks;

}
