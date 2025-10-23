package com.employeesCRUD.demo.service.Exceptions;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file DataBaseException
 * @since 23/10/2025 - 09:42
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
