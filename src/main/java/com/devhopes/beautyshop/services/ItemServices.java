package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Item;

import java.util.List;

public interface ItemServices {
    boolean updateSlot(Item item, Integer numberOfSlotsRemaining, String slotId, String bookingId);

    List<Item> getAllItems();
}
