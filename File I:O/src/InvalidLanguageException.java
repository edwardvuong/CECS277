/**
 * Creates new exception for invalid languages.
 * @author edwardvuong
 */

@SuppressWarnings("serial")
/**
 * Method for invalid languages.
 */
public class InvalidLanguageException extends Exception {
	public InvalidLanguageException() {		
		System.err.println("ERROR: Language is not supported, try again.");
	}
}