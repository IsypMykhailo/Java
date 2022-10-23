package com.mykhailo.timezone.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int quantity;
    private float rate;

    /*@OneToMany(mappedBy = "cart")
    @JsonIgnore
    private Set<Product> products;*/

    @ManyToMany (fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "carts_products",
            joinColumns = { @JoinColumn(name = "cart_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") })
    @JsonIgnore
    private Set<Product> products = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;*/

}
