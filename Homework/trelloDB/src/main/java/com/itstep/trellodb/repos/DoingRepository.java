package com.itstep.trellodb.repos;

import com.itstep.trellodb.entities.Doing;
import org.springframework.data.repository.CrudRepository;

public interface DoingRepository extends CrudRepository<Doing, Long> {
}
