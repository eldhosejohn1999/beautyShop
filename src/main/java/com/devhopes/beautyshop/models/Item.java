package com.devhopes.beautyshop.models;

import lombok.*;

import java.util.Date;
import java.util.List;


@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class Item {
    /**
     * Unique id of an Item
     */
    @NonNull
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
     *Which all dates are available, default available always
     */
    List<Date> datesAvailable;

    /**
     * Number of slots available a day
     */
    Integer numberOfSlotsPerDay;

    /**
     * Number of people per slot
     */
    Integer numberOfCustomersPerSlot;

    /**
     *List of all ratings users has given
     */
    List<Rating> ratings;
}
