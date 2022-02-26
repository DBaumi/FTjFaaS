package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when the container didn't print any results.
 */
public class EmptyContainerResultException extends Exception {
    private static final long serialVersionUID = 1L;

    public EmptyContainerResultException(String message) {
        super(message);
    }
}
