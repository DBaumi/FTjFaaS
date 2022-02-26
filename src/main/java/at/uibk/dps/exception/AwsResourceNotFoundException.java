package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when any of the needed AWS resources for jContainer is not found.
 */
public class AwsResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public AwsResourceNotFoundException(String message) {
        super(message);
    }
}
