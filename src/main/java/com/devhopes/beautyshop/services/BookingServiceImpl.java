package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.enums.*;
import com.devhopes.beautyshop.models.*;
import com.devhopes.beautyshop.repository.BookingResponseRepository;
import com.devhopes.beautyshop.repository.BookingsRepository;
import com.devhopes.beautyshop.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

import static com.devhopes.beautyshop.enums.Remarks_String.*;

@Slf4j
@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    BookingResponseRepository bookingResponseRepository;

    @Autowired
    AdminServices adminServices;

    @Autowired
    ItemServices itemServices;

    @Override
    public BookingResponse bookItem(Booking booking) {
        try {
            BookingResponse bookingResponse;
            bookingsRepository.save(booking);
            log.info("Saved the booking={}", booking);

            Optional<Item> itemToBook = itemsRepository.findById(booking.getItemId());

            if (itemToBook.isPresent()) {
                log.info("Item to book={}", itemToBook);
                Item item = itemToBook.get();
                if (item.isAvailable()) {
                    if (item.getNumberOfSlotsRemaining() > 0) {
                        if (item.isAdminConfirmationNeeded()) {
                            log.info("Item={} needs confirmation from admin via call", item);
                            adminServices.regesterBookingForConfirmation(booking);
                            log.info("Notified admin about the booking={} and item={}", booking, item);
                            if(itemServices.updateSlot(item, item.getNumberOfSlotsRemaining() - 1, booking.getSlotIdForBooking(), booking.getBookingId())){
                                log.info("Updated the slot={}", item);
                                bookingResponse = BookingResponse.builder()
                                        .id(UUID.randomUUID().toString())
                                        .bookingId(booking.getBookingId())
                                        .bookingStatus(Booking_Status.BOOKED_NEEDS_CONFIRMATION.value)
                                        .remarks(THANKS_WAIT_FOR_CALL.value)
                                        .build();
                            }else{
                                log.info("Slot is already booked={}", item);
                                bookingResponse = BookingResponse.builder()
                                        .id(UUID.randomUUID().toString())
                                        .bookingId(booking.getBookingId())
                                        .bookingStatus(Booking_Status.BOOKED_NEEDS_CONFIRMATION.value)
                                        .remarks(THANKS_WAIT_FOR_CALL.value)
                                        .build();
                            }

                        } else {
                            itemServices.updateSlot(item, item.getNumberOfSlotsRemaining() - 1, booking.getSlotIdForBooking(), booking.getBookingId());
                            log.info("Updated the slot={}", item);
                            bookingResponse = BookingResponse.builder()
                                    .id(UUID.randomUUID().toString())
                                    .bookingId(booking.getBookingId())
                                    .bookingStatus(Booking_Status.BOOKED.value)
                                    .remarks(THANKS_REMARKS.value)
                                    .build();
                        }
                    } else {
                        bookingResponse = BookingResponse.builder()
                                .id(UUID.randomUUID().toString())
                                .bookingId(booking.getBookingId())
                                .bookingStatus(Booking_Status.FAILED.value)
                                .remarks(NO_MORE_SLOTS.value)
                                .build();
                    }
                } else {
                    bookingResponse = BookingResponse.builder()
                            .id(UUID.randomUUID().toString())
                            .bookingId(booking.getBookingId())
                            .bookingStatus(Booking_Status.FAILED.value)
                            .remarks(ITEM_NOT_AVAILABLE.value)
                            .build();
                }
            } else {
                bookingResponse = BookingResponse.builder()
                        .id(UUID.randomUUID().toString())
                        .bookingId(booking.getBookingId())
                        .bookingStatus(Booking_Status.FAILED.value)
                        .remarks(ITEM_NOT_FOUND.value)
                        .build();
            }

            log.info("Saving bookingResponse={}", bookingResponse);
            bookingResponseRepository.save(bookingResponse);
            return bookingResponse;
        } catch (Exception e) {
            log.error("Error occurred={}", e);
            throw new RuntimeException(e);
        }
    }
}
