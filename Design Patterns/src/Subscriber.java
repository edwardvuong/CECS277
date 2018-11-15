/**
 * Subscriber.java
 *
 * Guests to the wait list. They register themselves with the
 * motel so that they are notified when a new room is available.
 */
public class Subscriber implements Observer {
	
	private Subject guest;
	private RoachColony colony;
	
	public Subscriber(Subject guest, RoachColony colony) {
		this.guest = guest;
		this.colony = colony;
		guest.addObserver(this);
	}

	public void update(Object newState) {
		String currentMotel = (String)newState;
		display(currentMotel);
	}
	
	/**
	 * Display a message to observers that a room has become vacant.
	 * @param motel Name of motel that has vacancy.
	 */
	public void display(String motel) {
		System.out.println("\nHello,\n" + colony +
				"\n\nYou are recieving this notice because you were previously added to our waiting list." +
				"\nA new room has become vacant at " + motel +
				".\nThis room is not reserved and may or may not be avaliable at the time of your check in." +
				"\nYou have now been removed from the waiting list and will no longer recieve notifications.");
	}
}
