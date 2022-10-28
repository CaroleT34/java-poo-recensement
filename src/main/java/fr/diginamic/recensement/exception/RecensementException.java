/**
 * RecensementException.java
 */
package fr.diginamic.recensement.exception;

/**
 * @author Krol
 *
 */
public class RecensementException extends Exception {

	/**Constructeur
	 *
	 */
	public RecensementException() {
	}

	/**Constructeur
	 *
	 * @param message
	 */
	public RecensementException(String message) {
		super(message);
	}

	/**Constructeur
	 *
	 * @param cause
	 */
	public RecensementException(Throwable cause) {
		super(cause);
	}

	/**Constructeur
	 *
	 * @param message
	 * @param cause
	 */
	public RecensementException(String message, Throwable cause) {
		super(message, cause);
	}

	/**Constructeur
	 *
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RecensementException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
