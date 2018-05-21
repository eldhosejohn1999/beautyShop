package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.enums.*;
import com.devhopes.beautyshop.models.*;
import com.devhopes.beautyshop.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;

public class BookingServiceImpl implements BookingService {

    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public BookingResponse bookItem(Booking booking) {
        Optional<Item> itemToBook = itemsRepository.findById(booking.getItemId());
        if (itemToBook.isPresent()) {
            Item item = itemToBook.get();
            if (item.isAvailable()) {
                if(item.getNumberOfSlotsRemaining()>0){

                }else{
                    return BookingResponse.builder()
                            .id(UUID.randomUUID().toString())
                            .bookingId(booking.getBookingId())
                            .bookingStatus(Booking_Status.FAILED.value)
                            .remarks(Remarks_String.NO_MORE_SLOTS.value)
                            .build();
                }
            } else {
                return BookingResponse.builder()
                        .id(UUID.randomUUID().toString())
                        .bookingId(booking.getBookingId())
                        .bookingStatus(Booking_Status.FAILED.value)
                        .remarks("Item not found")
                        .build();
            }
        }
        return null;
    }
}
