package org.camiloleal.adapters.rest.exceptions_handler;

public class ErrorMessage {

    private final String error;

    private final String message;

    private static final String ERROR_MESSAGE = "Ha ocurrido un error contacte con el Administrador";

    public ErrorMessage(Exception exception) {
        this.error = exception.getClass().getSimpleName();
        this.message = ERROR_MESSAGE;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorMessage{" + "error='" + error + '\'' + ", message='" + message + '\'' + '}';
    }
}
