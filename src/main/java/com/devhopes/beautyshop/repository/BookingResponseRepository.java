package com.devhopes.beautyshop.repository;

import com.devhopes.beautyshop.models.BookingResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookingResponseRepository extends CrudRepository<BookingResponse, String> {

}
