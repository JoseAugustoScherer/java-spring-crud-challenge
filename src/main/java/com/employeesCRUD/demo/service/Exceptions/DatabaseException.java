package com.employeesCRUD.demo.service.Exceptions;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file DataBaseException
 * @since 23/10/2025 - 09:42
 */

public class DatabaseException extends RuntimeException {
    public DatabaseException(String message) {
        super(message);
    }
}
