package org.camiloleal.domain.exceptions;

public class ConflictException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String DESCRIPTION = "Conflict Exception (409)";

    public ConflictException(String message) {
        super(DESCRIPTION + ". " + message);
    }

}