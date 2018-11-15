/**
 * AutoRefill.java
 * 
 * Creates a concrete instance of auto refill
 *
 */
public class AutoRefill extends RoomDecorator {

	protected RoachMotel amenitiy;

	public static final int COST = 5;

	public AutoRefill(RoachMotel amenity) {
		this.amenitiy = amenity;
	}
	
	public String getDescription() {
		return amenitiy.getDescription() + " with autorefill";
	}

	public String getReceipt() {
		return amenitiy.getReciept() + "\nAuto refill: $" + COST + " per night";
	}
	
	public int cost() {
		return amenitiy.cost() + COST;
	}

}
