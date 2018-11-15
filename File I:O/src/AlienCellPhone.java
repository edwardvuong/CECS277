/**
 * Interface for AlienCellPhone
 * @author edwardvuong
 */

public interface AlienCellPhone {
	/** Uses EarthText to send a message, if languageType is alien, translate to alien language*/
	public void sendText(String languageType, String fileName);
	/** Detects alien languages, translates to English*/
	public void readText(String languageType, String fileName);
	/** Translates text based on languageType, write translated text in fileName*/
	public void translateText(String languageType, String fileName);
}