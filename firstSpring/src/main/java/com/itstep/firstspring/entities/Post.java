package com.itstep.firstspring.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name="posts")
public class Post {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;

    @Id
    private UUID id = UUID.randomUUID();

    private String title;
    private String body;
    private String impUrl;

    // Реализовано благодаря lombok
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
