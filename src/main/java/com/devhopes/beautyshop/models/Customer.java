package com.devhopes.beautyshop.models;

import lombok.*;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Value
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(toBuilder = true)
@Entity
public class Customer {
    /**
     * Unique id for a customer
     */
    @NonNull
    @Id
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
    @ElementCollection(targetClass=Item.class)
    List<Item> customerFavourites;
}
