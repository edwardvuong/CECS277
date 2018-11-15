import java.util.HashSet;
import java.util.Set;

/**
 * Tester.java
 * 
 * A tester class which creates a set of various amenities and tests various motel methods such as
 * check in, check out, throw party, and increase stay.
 * 
 * Name: Edward Vuong
 * Date: December 11, 2017
 * Purpose: Create a roach motel using the singleton, decorator, factory, and observer design patterns.
 * Input: None 
 * Output: Attached to back
 * 
 * @author Edward Vuong
 */
public class Tester {
	
	/* Invoke Singleton pattern to return single instance of a motel.  */
	public static MotelSingleton roachMotel = MotelSingleton.getInstance();
	/* A hash set of amenities a guest can add to their room*/
	public static Set<String> amenities = new HashSet<>();
	
	public static void main(String[] args) {
		
		System.out.println(roachMotel);

		amenities.add("shower");
		amenities.add("food bar");
		RoachColony guest1 = new RoachColony(8, "guest1", 2);
		roachMotel.checkIn(guest1, amenities);
		guest1.increaseStay(2);
		guest1.throwParty();
		
		amenities = new HashSet<>();
		amenities.add("spa");
		amenities.add("auto refill");
		RoachColony guest2 = new RoachColony(12, "guest2", 3);
		roachMotel.checkIn(guest2,amenities);
	
		amenities = new HashSet<>();
		RoachColony guest3 = new RoachColony(4, "guest3", 6);
		roachMotel.checkIn(guest3,amenities);
		
		amenities = new HashSet<>();
		amenities.add("spa");
		amenities.add("shower");
		amenities.add("auto refill");
		amenities.add("food bar");
		RoachColony guest4 = new RoachColony(6, "guest4", 2);
		roachMotel.checkIn(guest4,amenities);
		guest4.increaseStay(6);
		
		amenities = new HashSet<>();
		amenities.add("spa");
		amenities.add("auto refill");
		amenities.add("food bar");
		RoachColony guest5 = new RoachColony(2, "guest5", 4);
		roachMotel.checkIn(guest5,amenities);
		guest5.throwParty();
		
		amenities = new HashSet<>();
		amenities.add("spa");
		amenities.add("shower");
		RoachColony guest6 = new RoachColony(7, "guest6", 5);
		roachMotel.checkIn(guest6,amenities);
		
		amenities = new HashSet<>();
		amenities.add("shower");
		RoachColony guest7 = new RoachColony(1, "guest7", 3);
		roachMotel.checkIn(guest7,amenities);
		
		roachMotel.checkOut(guest1);
		roachMotel.checkOut(guest2);

	}
} 