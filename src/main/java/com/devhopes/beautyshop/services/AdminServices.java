package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Booking;

public interface AdminServices {
    void regesterBookingForConfirmation(Booking booking);
    void addTestData();
}
