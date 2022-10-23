package com.mykhailo.timezone.repos;

import com.mykhailo.timezone.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
