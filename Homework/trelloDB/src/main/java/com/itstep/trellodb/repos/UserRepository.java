package com.itstep.trellodb.repos;

import com.itstep.trellodb.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, Long> {
}
