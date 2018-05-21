package com.devhopes.beautyshop.repository;

import com.devhopes.beautyshop.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemsRepository extends CrudRepository<Item, String> {

}
