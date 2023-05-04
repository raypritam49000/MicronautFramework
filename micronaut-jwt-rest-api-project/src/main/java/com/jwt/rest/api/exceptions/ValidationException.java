package com.jwt.rest.api.exceptions;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ValidationException extends RuntimeException {
    private final Set<ConstraintViolation<?>> violations;

    public ValidationException(Set<ConstraintViolation<?>> violations) {
        super("Validation failed for object: " + violations.iterator().next().getRootBeanClass().getSimpleName());
        this.violations = violations;
    }

    public Set<ConstraintViolation<?>> getViolations() {
        return violations;
    }
}