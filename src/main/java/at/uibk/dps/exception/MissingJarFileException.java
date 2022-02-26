package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when the jar file cannot be found.
 */
public class MissingJarFileException extends Exception {
    private static final long serialVersionUID = 1L;

    public MissingJarFileException(String message) {
        super(message);
    }
}
