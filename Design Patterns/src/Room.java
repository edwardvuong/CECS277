/**
 * Room.java
 * 
 * Creates a concrete instance of a room
 *
 */
public class Room extends RoomDecorator{
	
	public static final int COST = 50;

	public Room() {}
	
	public String getDescription() {
		return "room";
	}

	public String getReceipt() {
		return "\nRoom: $" + COST + " per night";
	}
	
	public int cost() {
		return COST ;
	}
}
