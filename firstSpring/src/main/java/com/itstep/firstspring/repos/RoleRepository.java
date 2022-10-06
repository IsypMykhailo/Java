package com.itstep.firstspring.repos;

import com.itstep.firstspring.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
