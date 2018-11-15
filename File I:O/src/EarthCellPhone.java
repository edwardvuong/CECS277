/**
 * Interface for EarthCellPhone
 * @author edwardvuong
 */

public interface EarthCellPhone{
	/** Prompts user for a message to send, saves message as a file*/
	public void sendMessage(String languageType, String fileName);
	/** Given fileName reads contents of file.*/
	public void readMessage(String languageType, String fileName);
}