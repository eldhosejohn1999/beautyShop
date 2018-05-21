package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.models.Item;
import com.devhopes.beautyshop.models.Slot;
import com.devhopes.beautyshop.repository.ItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemServicesImpl implements ItemServices {

    @Autowired
    ItemsRepository itemsRepository;
    boolean isSlotFound = false;

    private void updateItem(Item item, Integer numberOfSlotsRemaining, List<Slot> slots) {
        itemsRepository.save(Item.builder()
                .id(item.getId())
                .description(item.getDescription())
                .name(item.getName())
                .durationInMinutes(item.getDurationInMinutes())
                .datesAvailable(item.getDatesAvailable())
                .TotalSlotsPerDay(item.getTotalSlotsPerDay())
                .numberOfSlotsRemaining(numberOfSlotsRemaining)
                .numberOfCustomersPerSlot(item.getNumberOfCustomersPerSlot())
                .isAvailable(item.isAvailable())
                .slots(slots)
                .ratings(item.getRatings())
                .build());
        isSlotFound = true;
    }

    public boolean updateSlot(Item item, Integer numberOfSlotsRemaining, String slotId, String bookingId) {
        isSlotFound = false;
        List<Slot> slots = item.getSlots();
        slots.forEach(slot -> {
            if (slot.getSlotId().equals(slotId)) {
                if (!slot.isBooked() && slot.getBookingId().isEmpty()) {
                    slot.setBookingId(bookingId);
                    slot.setBooked(true);
                    updateItem(item, numberOfSlotsRemaining, slots);
                }
            }
        });
        return isSlotFound;
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        itemsRepository.findAll().forEach(items::add);
        return items;
    }
}
