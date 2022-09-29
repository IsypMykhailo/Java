package com.itstep.firstspring.entities.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "portfolio_items")
public class PortfolioItem {

    //*---------------------------------
    // One to Many
    @ManyToOne
    @JoinColumn(name = "category_id")
    private PortfolioCategory category;

    //*---------------------------------
    // Many to Many
    @ManyToMany (fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "portfolio_items_tags",
            joinColumns = { @JoinColumn(name = "portfolio_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    @JsonIgnore
    private Set<PortfolioTag> tags = new HashSet<>();


    //*---------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name; // Наименование работы
    private String mainImg; // Ссылка на главное изображение
    @Column(columnDefinition="TEXT")
    private String description; // Опсиание работы
    private Integer price; // Стоимость
    private Integer time; // Затраченное время в часах

    @CreationTimestamp
    private Date created_at; // = new Date();


}
