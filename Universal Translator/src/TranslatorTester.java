import java.util.Scanner;

/**
 * Tester class implementing user interface.
 * 
 * Name: Edward Vuong
 * Date: November 8, 2017
 * Purpose: File I/O & Adapater Design pattern
 * Input: User input selecting options from menu 
 * Output: Attached to back
 * @author edwardvuong
 * 
 */
public class TranslatorTester{
	public static void main(String[] args) throws Exception{
		int menu = 1;	
		/** Array of supported languages */
		String[] languages = { "Vulcan", "Kligon", "Ferrengi", "Earth" };
		/** Boolean check if valid language*/
		Boolean invalid;
		Boolean caught = false;
		System.out.println("Star Trek Universal Translator:");
		while (menu != 1 || menu != 2)
		{
			invalid = true;
			System.out.println("	1. Send a message. \n	2. Read a message. \n 	3. Exit. ");
			Scanner input = new Scanner(System.in);
			EarthText ett = new EarthText();
			menu = input.nextInt();
			AlienAdapter alien;

			if (menu == 1) {
				String langaugeType = null;
				try 
				{
					System.out.println("What language would you like to send your message in?");
					langaugeType = input.next();
					for(int i = 0; i < languages.length; i++)
					{
						if(langaugeType.equalsIgnoreCase(languages[i]))
							invalid = false;
					}
					if(invalid)
						throw new InvalidLanguageException();
				}catch(InvalidLanguageException n) {
					caught = true;
				}

				if(caught == false) 
				{
					System.out.println("Send message as file: ");
					String fileName = input.next();
					alien = new AlienAdapter();
					if(langaugeType.equalsIgnoreCase("Earth"))
						ett.sendMessage(langaugeType, fileName);
					else
					{
						alien.sendText(langaugeType, fileName);
						System.out.println("Your message has been translated.");
					}

					System.out.println("\nMessage:");
					ett.readMessage(langaugeType, fileName);
					System.out.println("\nSent.");
				}
			}

			else if (menu == 2) 
			{
				String langaugeType = null;
				try 
				{
					System.out.println("What language is your message in?");
					langaugeType  = input.next();
					for(int i = 0; i < languages.length; i++)
					{
						if(langaugeType.equalsIgnoreCase(languages[i]))
							invalid = false;
					}
					if(invalid)
						throw new InvalidLanguageException();
				}catch(InvalidLanguageException n) {
					caught = true;
				}

				if(caught == false) 
				{
					System.out.println("Enter file name of message to be read:");
					String file = input.next();
					alien = new AlienAdapter();
					System.out.println("Message...");
					ett.readMessage(langaugeType, file);
					if(!langaugeType.equalsIgnoreCase("Earth"))
						alien.readText(langaugeType, file);
				}
			}
				else
				{
					System.out.println("End program.");
					break;
				}
			}
	}	
}