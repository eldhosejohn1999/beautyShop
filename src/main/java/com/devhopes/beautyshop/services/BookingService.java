package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Booking;
import com.devhopes.beautyshop.models.BookingResponse;

public interface BookingService {

    BookingResponse bookItem(Booking booking);

}
