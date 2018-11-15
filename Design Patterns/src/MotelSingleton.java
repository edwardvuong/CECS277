import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * MotelSingleton.java
 * 
 * This uses the Singleton pattern to create a single instance of motel. 
 * 
 */
public class MotelSingleton{
	/* Get single instance of the roach motel */
	private static MotelSingleton roachMotel = new MotelSingleton();
	/* Creates a wait list */
	private static Waitlist waitlist = new Waitlist();
	/* Creates a room factory */
	private static RoomFactory factory = new RoomFactory();
	/* Creates a room */
	private static RoomDecorator currentRoom = new Room();
	/* Motel room capacity */
	private static int TOTAL_ROOMS = 5;
	/* Amount of occupied */
	private static int occupiedRooms = 0;	
	/* Vacancy status */
	private static boolean vacancy = true;
	/* Name of the motel */
	private static String name = "Bates Motel";
	/* hello */
	public static Map<RoachColony, Set<String>> map = new HashMap<RoachColony, Set<String>>();
	
	public static ArrayList<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * Private constructor
	 */
	private MotelSingleton() { }
	
	/**
	 * Getter method for singleton pattern
	 * @return singular instance of a roach motel
	 */
	public static MotelSingleton getInstance() {
		return roachMotel;
	}

	/**
	 * Check in a guest
	 * @param colony Roach Colony to check in
	 * @param amenities Set of amenities to add to room
	 */
	public void checkIn(RoachColony colony, Set<String> amenities) {
		map.put(colony, amenities); // key = colony value = amenities
		if (occupiedRooms == TOTAL_ROOMS)
		{
			vacancy = false;
			System.out.println(this);
			System.out.println("\nSorry, no rooms are avaliable. " + colony +
					"\nYou've been added to the waiting list and will recieve notice when a room is avaliable.");
			/* invoke observer pattern ?? idk if i did this right  */
			new Subscriber(waitlist, colony);
		}
		else
		{
			currentRoom = factory.getRoom(amenities);
			System.out.println("\n\nCHECK IN \n" + colony + 
					"\nHere are the keys to your " + currentRoom.getDescription());
			occupiedRooms += 1;
			System.out.println(this);
		}
	}
	
	/**
	 * Check out a guest
	 * @param colony Roach Colony to check out
	 */
	public void checkOut(RoachColony colony) {
		currentRoom = factory.getRoom(map.get(colony)); // use key colony to obtain amenities and pass through factory to get colony room
		Random random = new Random();
		System.out.println("\n\nCHECK OUT \n" + colony +
				"\nYou have stayed with us for " + colony.getDaysStayed() + " night(s)" +
				currentRoom.getReciept() + "\nVisa **** **** **** " + (random.nextInt((9999 - 1000) + 1) + 1000) +
				" has been charged $" + (colony.getDaysStayed() * currentRoom.cost()) +
				"\nThank you for staying with us, we hope you enjoyed your stay " + colony.getColonyName() + "!");
		occupiedRooms -= 1;
		map.remove(colony);
		if (occupiedRooms+1 == TOTAL_ROOMS)
			vacancy = true;
		System.out.println(this);	
		if (occupiedRooms+1 == TOTAL_ROOMS)
			waitlist.notifyObservers();
	}
	
	/**
	 * Getter method for map
	 * @return map containing key = colony, value = amenity set
	 */
	public Map<RoachColony, Set<String>> getMap() {
		return map;
	}
	
	/**
	 * Getter method for vacancy
	 * @return vacancy status
	 */
	public boolean getVacancy() {
		return vacancy;
	}
	
	/**
	 * Getter method for motel name
	 * @return motel name
	 */
	public String getMotelName() {
		return name;
	}
	
	/**
	 * Getter method for amount of rooms occupied
	 * @return amount of rooms occupied
	 */
	public int getOccupiedRooms() {
		return occupiedRooms;
	}
	
	/**
	 * Getter method for total amount of rooms
	 * @return total rooms in the motel
	 */
	public int getTotalRooms() {
		return TOTAL_ROOMS;
	}
	
	/**
	 * Returns a string representation of roach motel
	 */
	public String toString() {
		if(vacancy == true)
			return ("\n\n —————————----------———————————-\n" + 
					"|				|\n" + 
					"|	   " + name + "		|\n" + 
					"|				|\n" + 
					"|	     VACANCY  		|\n" + 
					"|				|\n" + 
					"|      " + occupiedRooms + "/" + 
					TOTAL_ROOMS + " room(s) occupied	|\n|				|" +
					"\n ——————————----------——————————-");
		else
			return ("\n\n —————————----------———————————-\n" + 
					"|				|\n" + 
					"|	   " + name + "		|\n" + 
					"|				|\n" + 
					"|	    NO VACANCY		|\n" + 
					"|				|\n" + 
					"|      " + occupiedRooms + "/" + 
					TOTAL_ROOMS + " room(s) occupied	|\n|				|" +
					"\n ——————————----------——————————-");
	}
}
