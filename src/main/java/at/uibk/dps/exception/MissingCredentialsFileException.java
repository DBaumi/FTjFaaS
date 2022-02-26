package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when no credentials file in directory is provided.
 */
public class MissingCredentialsFileException extends Exception {

    private static final long serialVersionUID = 1L;

    public MissingCredentialsFileException(String message){super(message);}
}
