package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when the AWS CLI is not installed or running.
 */
public class MissingAwsCliException extends Exception {
    private static final long serialVersionUID = 1L;

    public MissingAwsCliException(String message) {
        super(message);
    }
}
