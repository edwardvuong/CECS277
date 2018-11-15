import java.util.Set;

/**
 * RoomFactory.java
 * 
 * This class uses the factory pattern along with the decorator pattern to create a room given a set of amenities.
 */
public class RoomFactory{
	
	/**
	 * Uses factory pattern to get a room.
	 * @param amenities A set of amenities to add to an empty room.
	 * @return decorated room
	 */
	public RoomDecorator getRoom(Set<String> amenities) {
		RoomDecorator room = new Room();
		if(amenities.contains("spa"))
			room = new Spa(room);
		if(amenities.contains("shower"))
			room = new Shower(room);
		if(amenities.contains("auto refill"))
			/* Must contain a food bar in order to auto refill */
			if(!amenities.contains("food bar"))
				room = new AutoRefill(new FoodBar(room));	
			else
				room = new AutoRefill(room);
		if(amenities.contains("food bar"))
			room = new FoodBar(room);
		return room;
	}
	
}
