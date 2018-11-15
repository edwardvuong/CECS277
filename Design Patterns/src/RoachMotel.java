/**
 * RoachMotel.java
 * 
 * Interface for component, instances of this class will be decorated using the decorator pattern.
 *
 */
public abstract class RoachMotel {
	
	/* Description of room with all decorators */
	protected String description;
	
	/* Receipt of room with cost of all decorators */
	protected String reciept;
	
	/**
	 * Description of all items billed to room
	 * @return description of all items
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Receipt of all items billed to room
	 * @return receipt of all items
	 */
	public String getReciept() {
		return reciept;
	}
	
	/**
	 * Total cost of the room
	 */
	public abstract int cost();
}