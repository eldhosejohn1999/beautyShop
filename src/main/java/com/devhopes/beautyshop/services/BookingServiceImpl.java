package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.enums.*;
import com.devhopes.beautyshop.models.*;
import com.devhopes.beautyshop.repository.BookingResponseRepository;
import com.devhopes.beautyshop.repository.BookingsRepository;
import com.devhopes.beautyshop.repository.CustomerRepository;
import com.devhopes.beautyshop.repository.ItemsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

import static com.devhopes.beautyshop.enums.Booking_Status.*;
import static com.devhopes.beautyshop.enums.Remarks_String.*;

@Slf4j
@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    BookingsRepository bookingsRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingResponseRepository bookingResponseRepository;

    @Autowired
    AdminServices adminServices;

    @Autowired
    ItemServices itemServices;

    private BookingResponse tryUpdateSlot(Item item, Booking booking, Booking_Status booking_status, Remarks_String remarks_string) {
        if (itemServices.updateSlot(item, item.getNumberOfSlotsRemaining() - 1, booking.getSlotIdForBooking(), booking.getBookingId())) {
            log.info("Updated the slot={}", item);
            return BookingResponse.build(booking.getBookingId(), booking_status, remarks_string);
        }
        else {
            log.info("Slot is already booked={}", item);
            return BookingResponse.build(booking.getBookingId(), FAILED, SLOT_ALREADY_BOOKED);
        }
    }

    @Override
    public BookingResponse bookItem(Booking booking) {
        try {
            BookingResponse bookingResponse;
            bookingsRepository.save(booking);
            log.info("Saved the booking={}", booking);
            if (customerRepository.findById(booking.getCustomerId()).isPresent()) {
                log.info("Customer is valid");
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
                                bookingResponse = tryUpdateSlot(item, booking, BOOKED_NEEDS_CONFIRMATION, THANKS_WAIT_FOR_CALL);

                            } else {
                                bookingResponse = tryUpdateSlot(item, booking, BOOKED, THANKS_REMARKS);
                            }
                        } else {
                            bookingResponse = BookingResponse.build(booking.getBookingId(), FAILED, NO_MORE_SLOTS);
                        }
                    } else {
                        bookingResponse = BookingResponse.build(booking.getBookingId(), FAILED, ITEM_NOT_AVAILABLE);
                    }
                } else {
                    bookingResponse = BookingResponse.build(booking.getBookingId(), FAILED, ITEM_NOT_FOUND);
                }

            } else {
                log.info("Customer is invalid");
                bookingResponse = BookingResponse.build(booking.getBookingId(), FAILED, CUSTOMER_NOT_FOUND);
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
