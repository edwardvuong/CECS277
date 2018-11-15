/**
 * RoomDecorator.java
 * 
 * Component, instances of this class will be decorated using the decorator pattern.
 *
 */
public abstract class RoomDecorator extends RoachMotel{
	
	/* Amenity to add to room */
	protected RoachMotel amenitiy;

	/* Cost of concrete instance */
	public static final int COST = 0;
	
	/**
	 * Overrides getDescription to add this concrete instance to the description. 
	 */
	public abstract String getDescription();
	
	/**
	 * Overrides getReciept to add this concrete instance to the receipt.
	 */
	public abstract String getReceipt();
}
