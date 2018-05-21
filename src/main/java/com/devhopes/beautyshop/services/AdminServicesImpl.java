package com.devhopes.beautyshop.services;

import com.devhopes.beautyshop.enums.Ratings;
import com.devhopes.beautyshop.models.Booking;
import com.devhopes.beautyshop.models.Item;
import com.devhopes.beautyshop.models.Rating;
import com.devhopes.beautyshop.repository.ItemsRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@Component
public class AdminServicesImpl implements AdminServices {
    @Autowired
    ItemsRepository itemsRepository;

    @Override
    public void regesterBookingForConfirmation(Booking booking) {

    }

    @Override
    public void addTestData() {
        for (int i = 0; i < 5; i++) {
            itemsRepository.save(Item.builder()
                    .id(UUID.randomUUID().toString())
                    .description("Item Description" + UUID.randomUUID().toString().substring(0, 5))
                    .name("Item name")
                    .durationInMinutes(123)
                    .datesAvailable(Arrays.asList(DateTime.now().toDate(), DateTime.now().plusDays(1).toDate(), DateTime.now().plusDays(2).toDate(), DateTime.now().plusDays(3).toDate()))
                    .isAdminConfirmationNeeded(true)
                    .isAvailable(true)
                    .TotalSlotsPerDay(5)
                    .numberOfSlotsRemaining(5)
                    .numberOfCustomersPerSlot(1)
                    .ratings(Arrays.asList(Rating.builder()
                            .starsOutOfFive(3)
                            .userRating(Ratings.AVERAGE)
                            .review("Nice").build()))
                    .build());
        }

    }
}
