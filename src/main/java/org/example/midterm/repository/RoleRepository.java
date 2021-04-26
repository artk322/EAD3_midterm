package org.example.midterm.repository;

import org.example.midterm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query(value = "SELECT * FROM role u Where u.name=?1", nativeQuery = true)
    Role find(String name);

}
