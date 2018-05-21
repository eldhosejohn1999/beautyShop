package com.devhopes.beautyshop.controller;

import com.devhopes.beautyshop.models.Booking;
import com.devhopes.beautyshop.models.BookingResponse;
import com.devhopes.beautyshop.models.Item;
import com.devhopes.beautyshop.services.BookingService;
import com.devhopes.beautyshop.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop/beauty_shop/v1")
public class BeautyShopController {

    @Autowired
    BookingService bookingService;

    @Autowired
    ItemServices itemServices;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookingResponse> bookSlotsForItem(@RequestBody @NotNull Booking booking) {
        return ResponseEntity.ok(bookingService.bookItem(booking));
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllItems")
    public List<Item> getAllItems() {
        return itemServices.getAllItems();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllItems")
    public String getNextBookingId(){
        return UUID.randomUUID().toString();
    }
}
