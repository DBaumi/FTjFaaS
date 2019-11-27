package dps.FTinvoker.exception;

/**
 * -Custom exception which is thrown when Function is not found on FaaS provider
 * 
 * @author Matteo Battaglin
 *
 */
public class AuthenticationFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthenticationFailedException(String message) {
		super(message);
	}
}