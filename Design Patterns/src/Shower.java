/**
 * Shower.java
 * 
 * Creates a concrete instance of a spray resistant shower.
 *
 */
public class Shower extends RoomDecorator {

	protected RoachMotel amenitiy;

	public static final int COST = 25;

	public Shower(RoachMotel amenity) {
		this.amenitiy = amenity;
	}

	public String getDescription() {
		return amenitiy.getDescription() + " with a spray resistant shower";
	}
	
	public String getReceipt() {
		return amenitiy.getReciept() + "\nSpray resistant shower: $" + COST + " per night";
	}

	public int cost() {
		return amenitiy.cost() + COST;
	}

}
