package com.mykhailo.timezone.repos;

import com.mykhailo.timezone.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
