package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when a mandatory key in the credentials file is not set.
 */
public class MissingMandatoryKeyInCredentialsFileException extends Exception {

    private static final long serialVersionUID = 1L;

    public MissingMandatoryKeyInCredentialsFileException(String message){super(message);}
}
