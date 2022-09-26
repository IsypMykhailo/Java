package com.itstep.trellodb.repos;

import com.itstep.trellodb.entities.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
