package com.devhopes.beautyshop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Slot {

    /**
     * Unique id for a slot
     */
    @Id
    String slotId;

    /**
     * Booking Id of the booking made for the current slot
     */
    String bookingId;

    /**
     * Status of booking
     */
    boolean isBooked;

    /**
     * Begin Time of the slot for eg. 10AM
     */
    String beginTime;

    /**
     * End time of the slot for eg. 10.30AM
     */
    String endTime;
}
