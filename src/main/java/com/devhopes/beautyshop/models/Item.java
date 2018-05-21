package com.devhopes.beautyshop.models;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
public class Item {
    /**
     * Unique id of an Item
     */
    @NonNull
    @Id
    String id;

    /**
     * Short Name not exceeding 3 words
     */
    @NonNull
    String name;

    /**
     * Full description about the process
     */
    @NonNull
    String description;

    /**
     * How much time it will take to finish, Optional
     */
    long durationInMinutes;

    /**
     * Which all dates are available, default available always
     */
    @ElementCollection(targetClass=Date.class)
    List<Date> datesAvailable;

    /**
     * Total Number of slots available a day
     */
    @NonNull
    Integer TotalSlotsPerDay;

    /**
     * Remaining Number of slots for the day
     */
    @Setter
    Integer numberOfSlotsRemaining;

    /**
     * Number of people per slot
     */
    Integer numberOfCustomersPerSlot;

    /**
     * List of all ratings users has given
     */
    @Embedded
    @ElementCollection(targetClass=Rating.class)
    List<Rating> ratings;

    /**
     * Is available or not, default is true
     */
    boolean isAvailable;

    /**
     * Needs confirmation via call, default false
     */
    boolean isAdminConfirmationNeeded;

    /**
     * Slots which defines the timings and the booking details if any
     */
    @Embedded
    @ElementCollection(targetClass=Slot.class)
    List<Slot> slots;
}
