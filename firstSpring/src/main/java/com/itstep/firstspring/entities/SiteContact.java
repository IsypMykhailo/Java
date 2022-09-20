package com.itstep.firstspring.entities;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name="site_contacts")
public class SiteContact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String message;

    @Column(name="created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt = new Date();

    @LastModifiedDate
    @Column(name="updated_at")
    private Date updatedAt;
}
