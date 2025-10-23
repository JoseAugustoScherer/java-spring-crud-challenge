package com.employeesCRUD.demo;

import com.employeesCRUD.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ClientRepository
 * @since 23/10/2025 - 09:12
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Integer id(Long id);
}
