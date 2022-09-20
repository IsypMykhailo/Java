package com.itstep.firstspring.repos;

import com.itstep.firstspring.entities.Post;
import org.springframework.data.repository.CrudRepository;


public interface PostRepository extends CrudRepository<Post, Long> {
}
