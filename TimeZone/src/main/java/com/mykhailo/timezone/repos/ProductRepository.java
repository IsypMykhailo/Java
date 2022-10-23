package com.mykhailo.timezone.repos;

import com.mykhailo.timezone.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
