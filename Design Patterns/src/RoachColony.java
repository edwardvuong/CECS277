import java.util.Map;
import java.util.Set;

/**
 * RoachColony.java
 *
 * Creates a new object of type RoachColony representing a colony of roaches and their features.
 */
public class RoachColony{
	
	/* Total population */
	private int population;
	/* Growth rate */
	private int growthRate;
	/* Total days checked in */
	private int daysStayed = 1;
	/* Motel name */
	private String name;
	/* Get single instance of the roach motel */
	private static MotelSingleton roachMotel = MotelSingleton.getInstance();
	/* Getter method for map of amenities*/
	private static Map<RoachColony, Set<String>> map = roachMotel.getMap();
	
	/**
	 * Constructs a default roach colony.
	 */
	public RoachColony() {
		population = 10;
		name = "Default";
		growthRate = 2;
	}

	/**
	 * Constructs a roach colony with given parameters.
	 * @param pop Colony population
	 * @param colony Colony name
	 * @param rate Colony growth rate
	 */
	public RoachColony(int pop, String colony, int rate) {
		population = pop;
		name = colony;
		growthRate = rate;
	}

	/**
	 * Increases colony population if a party is thrown.
	 */
	public void throwParty() {
		if(!map.containsKey(this))
			System.err.println("\nERROR: " + name +" must be checked into a room in order to throw a party." );
		else
		{
			System.out.println("\nGuest " + name + " is throwing a party, their population has increased.");
			population = (int) (population * growthRate);
			
			System.out.println("\n\nHello, \n" + this + "\n\nWe have detected an increase in population." + 
								"\nParties are prohibited, a pestiside has been sprayed.");
			if(map.get(this).contains("shower"))
			{
				System.out.print("You have purcahsed a spray resistant shower." +
								"\nThe pestistide is 25% effective.\n");
				population = (int) (population*.75);
			}
			else
			{
				System.out.print("You have not purcahsed a spray resistant shower." +
								"\nThe pestistide is 50% effective.\n");
				population = (int) (population*.5);
			}
			System.out.println(this);
		}
	}

	/**
	 * Getter method for colony population.
	 * @return colony population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * Getter method for colony name
	 * @return colony name
	 */
	public String getColonyName() {
		return name;
	}

	/**
	 * Getter method for colony growth rate
	 * @return colony growth rate
	 */
	public double getGrowthRate() {
		return growthRate;
	}
	
	/**
	 * Increases amount of days stayed
	 * @param days amount of days to increase stay by
	 */
	public void increaseStay(int days) {
		daysStayed += days;
		System.out.println("\nGuest " + name + " has requested to stay for an additional " + days + " day(s).");
	}
	
	/**
	 * Getter method for amount of days colony has been checked in
	 * @return total amount of days stayed
	 */
	public int getDaysStayed() {
		return daysStayed;
	}

	/**
	 * Returns a string representation of colony
	 */
	public String toString() {
		return ("\nRoach Colony: " + name +
				"\nPopulation: " + population +
				"\nGrowth Rate: " + growthRate);
	}

}
