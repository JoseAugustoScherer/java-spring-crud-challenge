package com.employeesCRUD.demo.dto;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file FieldMessage
 * @since 23/10/2025 - 15:20
 */
public class FieldMessage {

    private final String fieldName;
    private final String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

}
