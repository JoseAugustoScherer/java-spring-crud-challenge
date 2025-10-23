package com.employeesCRUD.demo.dto;

import java.time.Instant;
import java.time.LocalDate;

/**
 * @author José Augusto Scherer - jose.a.scherer@gmail.com
 * @file CustomError
 * @since 23/10/2025 - 15:14
 */

public class CustomError {

    private Instant instant;
    private Integer status;
    private String error;
    private String path;

    public CustomError(Instant instant, Integer status, String error, String path) {
        this.instant = instant;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
