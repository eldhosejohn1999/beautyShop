package com.devhopes.beautyshop.repository;

import com.devhopes.beautyshop.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CustomerRepository  extends CrudRepository<Customer, String> {

}
