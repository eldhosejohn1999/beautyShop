package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Item;

public interface ItemServices {
    boolean updateSlot(Item item, Integer numberOfSlotsRemaining, String slotId, String bookingId);
}