package com.employeesCRUD.demo.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file ValidationError
 * @since 23/10/2025 - 15:20
 * --------------------
 * [ BRIEF DESCRIPTION OF THE CLASS PURPOSE GOES HERE ]
 * --------------------
 * --------------------
 * Reference documentation:
 * - [ Link to documentation, if any ]
 * --------------------
 */
public class ValidationError extends CustomError {

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Instant instant, Integer status, String error, String path) {
        super(instant, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName,  String message) {
        errors.add(new FieldMessage(fieldName, message));
    }

}
