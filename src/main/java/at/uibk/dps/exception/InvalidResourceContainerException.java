package at.uibk.dps.exception;
/**
 * Custom exception which is thrown when resource for Function is invalid.
 */
public class InvalidResourceContainerException extends Exception {
    private static final long serialVersionUID = 1L;

    public InvalidResourceContainerException(String message) {
        super(message);
    }
}
