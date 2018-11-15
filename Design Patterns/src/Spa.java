/**
 * Spa.java
 * 
 * Creates a concrete instance of a spa.
 *
 */
public class Spa extends RoomDecorator {
	
	protected RoachMotel amenitiy;

	public static final int COST = 20;

	public Spa(RoachMotel amenity) {
		this.amenitiy = amenity;
	}

	public String getDescription() {
		return amenitiy.getDescription() + " with a spa";
	}

	public String getReceipt() {
		return amenitiy.getReciept() + "\nSpa: $" + COST + " per night";
	}
	
	public int cost() {
		return amenitiy.cost() + COST;
	}

}
