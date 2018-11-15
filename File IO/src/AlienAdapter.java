import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Adapter class for support for alien languages. Translates supported alien languages from English to alien and alien to English.
 * @author edwardvuong
 */
public class AlienAdapter implements AlienCellPhone {
	/** EarthText object*/
	EarthText earth = new EarthText();

	/**
	 * Uses EarthText object to get Earth message in Earth language, translates Earth language to Vulcan, Kligon, or Ferrengi.
	 * @param languageType Language message is given in.
	 * @param fileName Location of message
	 */
	@Override
	public void sendText(String languageType, String fileName){
		earth.sendMessage(languageType, fileName);
		if (languageType.equalsIgnoreCase("Vulcan"))
			try {
				translateText("Vulcan", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		else if (languageType.equalsIgnoreCase("Kligon"))
			try {
				translateText("Kligon", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		else if (languageType.equalsIgnoreCase("Ferrengi"))
			try {
				translateText("Ferrengi", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * Detects alien languages, translates supported alien languages to Earth.
	 * @param languageType Language message is given in.
	 * @param fileName Location of message
	 */
	@Override
	public void readText(String languageType, String fileName){
		System.out.println("\nTranslating...");
		if (languageType.equalsIgnoreCase("Vulcan")) 
		{
			try {
				translateText("vulcanToEnglish", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			earth.readMessage(languageType, fileName + "_translated");
		}
		else if (languageType.equalsIgnoreCase("Ferrengi")) 
		{
			try {
				translateText("ferrengiToEnglish", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			earth.readMessage(languageType, fileName + "_translated");
		}
		else if (languageType.equalsIgnoreCase("Kligon")) 
		{
			try {
				translateText("kligonToEnglish", fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			earth.readMessage(languageType, fileName + "_translated");
		}
	}

	
	
	/**
	 * Translates text from English to Vulcan, Kligon, & Ferrengi, translates text from Vulcan, Kligon, & Ferrengi to English.
	 * @param languageType Language message is given in.
	 * @param fileName Name of file to saved translated text.
	 */
	@Override
	public void translateText(String languageType, String fileName){
		String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		String[] Vulcan = {"~","!","#","$","%","^","&","*","(",")","-","_","+","=","?","/",">","<",";","{","}","`","|","0","]","["};
		String[] Kligon = {" 72 "," 54 "," 23 "," 21 "," 83 "," 65 "," 35 "," 99 "," 66 "," 78 "," 32 "," 48 "," 12 "," 86 "," 07 "," 91 "," 38 "," 51 "," 24 "," 93 "," 97 "," 01 "," 44 "," 68 "," 00 "," 59 "};
		String[] Ferrengi = {" & "," 1 "," 2 "," 3 "," 9 "," # "," + "," 8 "," < "," ? "," 4 "," $ "," @ "," 86 "," ^ "," 7 "," 6 "," 5 "," * "," { "," } "," [ "," ] "," > "," , "," = "};
		
		File file = new File(fileName);
		Scanner input = new Scanner(System.in);
		try {
			input = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String message = null;
		while (input.hasNext()) 
			message = input.nextLine();
		message = message.toLowerCase();
		if(languageType.equalsIgnoreCase("Vulcan")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(alphabet[i], Vulcan[i]);
		}
		else if(languageType.equalsIgnoreCase("Kligon")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(alphabet[i], Kligon[i]);
		}
		else if(languageType.equalsIgnoreCase("Ferrengi")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(alphabet[i], Ferrengi[i]);
		}
		
		else if(languageType.equalsIgnoreCase("vulcanToEnglish")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(Vulcan[i], alphabet[i]);
			fileName = fileName + "_translated";
		}
		else if(languageType.equalsIgnoreCase("ferrengiToEnglish")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(Ferrengi[i], alphabet[i]);
			fileName = fileName + "_translated";
		}
		else if(languageType.equalsIgnoreCase("kligonToEnglish")) 
		{
			for(int i = 0; i < alphabet.length; i++)
				message = message.replace(Kligon[i], alphabet[i]);
			fileName = fileName + "_translated";
		}
		writeFile(fileName, message);
	}
	

	/**
	 * Given a file name and a message writes a message to a file.
	 * @param fileName File name to save as
	 * @param message Message to write in file
	 */
	private void writeFile(String fileName, String message){
		try{
			PrintWriter file = new PrintWriter(new File(fileName));
			file.println(message);
			file.close();
		} catch(FileNotFoundException fnf){
			System.err.println("File not found");
		}
	}

}
