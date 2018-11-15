/**
 * FoodBar.java
 * 
 * Creates a concrete instance of a food bar.
 *
 */
public class FoodBar extends RoomDecorator {

	protected RoachMotel amenitiy;

	public static final int COST = 10;

	public FoodBar(RoachMotel amenity) {
		this.amenitiy = amenity;
	}

	public String getDescription() {
		return amenitiy.getDescription() + " with a foodbar";
	}
	
	public String getReceipt() {
		return amenitiy.getReciept() + "\nFood bar: $" + COST + " per night";
	}

	public int cost() {
		return amenitiy.cost() + COST;
	}

}
