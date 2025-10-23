package com.employeesCRUD.demo.dto;

import com.employeesCRUD.demo.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ClientDTO
 * @since 21/10/2025 - 17:11
 * --------------------
 * Defines the Client entity attributes used in database transactions.
 * Exposing only the necessary data to the controller
 * --------------------
 */

public class ClientDTO {

    private Long id;

    @NotBlank ( message = "The name field cannot be empty!" )
    private String name;
    private String cpf;
    private Double income;

    @PastOrPresent ( message = "Past or present dates only!" )
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }
}
