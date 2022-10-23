package com.mykhailo.timezone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name="categories")
public class Category {
    @OneToMany(mappedBy = "category")
    @JsonIgnore
    @ToString.Exclude
    private Set<Product> products;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name; // Наименование категории

    @CreationTimestamp
    private Date created_at; // = new Date();
}
