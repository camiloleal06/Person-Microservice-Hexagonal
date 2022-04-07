package org.camiloleal.domain.exceptions;

public class NotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String DESCRIPTION = "Not Found Exception (404)";

    public NotFoundException(String message) {
        super(DESCRIPTION + ". " + message);
    }

}
