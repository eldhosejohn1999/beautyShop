package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Booking;
import com.devhopes.beautyshop.models.BookingResponse;
import org.springframework.stereotype.Component;

public interface BookingService {

    BookingResponse bookItem(Booking booking);

}
