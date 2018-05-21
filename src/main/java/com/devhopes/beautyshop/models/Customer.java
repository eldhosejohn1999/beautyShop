package com.devhopes.beautyshop.models;

import lombok.*;

import java.util.List;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
public class Customer {
    /**
     * Unique id for a customer
     */
    @NonNull
    String customerId;

    /**
     * Customer name
     */
    @NonNull
    String customerName;

    /**
     * Phone number of customer
     */
    @NonNull
    String customerPhone;

    /**
     * customer Email Id
     */
    @NonNull
    String customerEmail;

    /**
     * customer Address
     */
    String customerAddress;

    /**
     * Customers favourites
     */
    List<Item> customerFavourites;
}
