package com.company.inventory.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7805043533359944942L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
