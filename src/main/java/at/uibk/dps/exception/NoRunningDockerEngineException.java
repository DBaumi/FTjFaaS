package at.uibk.dps.exception;

/**
 * Custom exception which is thrown when the local docker engine is not yet started.
 */
public class NoRunningDockerEngineException extends Exception {

    private static final long serialVersionUID = 1L;

    public NoRunningDockerEngineException(String message) {
        super(message);
    }

}
