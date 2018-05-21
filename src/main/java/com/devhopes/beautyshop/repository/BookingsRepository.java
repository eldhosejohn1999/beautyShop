package com.devhopes.beautyshop.repository;

import com.devhopes.beautyshop.models.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookingsRepository extends CrudRepository<Booking, String> {

}
