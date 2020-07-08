package com.store.webStore.repos;

import com.store.webStore.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository {
    Roles findByRole(String role);
}
