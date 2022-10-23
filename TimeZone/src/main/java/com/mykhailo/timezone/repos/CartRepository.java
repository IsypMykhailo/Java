package com.mykhailo.timezone.repos;

import com.mykhailo.timezone.entities.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
