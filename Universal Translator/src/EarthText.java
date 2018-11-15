import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * Send and recieve messages on Earth in Earth language
 * @author edwardvuong
 */
public class EarthText implements EarthCellPhone {

	/**
	 * Gets a message from user and saves as a file.
	 * @param languageType Language message is given in.
	 * @param fileName File name to save as
	 */
	@Override
	public void sendMessage(String languageType, String fileName){
		System.out.println("What's your message?");
		Scanner input = new Scanner(System.in);
		String message = input.nextLine();
		try(PrintWriter output = new PrintWriter(fileName)) 
		{
			output.print(message);
		}//file is closed
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}


	/**
	 * Reads an exsiting message from file.
	 * @param languageType Language message is given in.
	 * @param fileName Location of message
	 */
	@Override
	public void readMessage(String languageType, String fileName) {
		File file = new File(fileName);
		try (Scanner input = new Scanner(file))
		{
			while (input.hasNext()) 
			{
				String message = input.nextLine();
				System.out.println(message);
			}//close file
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

}
