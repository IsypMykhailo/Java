package com.itstep.trellodb.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name="users")
public class User {

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<ToDo> toDos;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Doing> doings;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Done> dones;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
}
