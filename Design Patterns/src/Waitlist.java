import java.util.ArrayList;

/**
 * Waitlist.java
 *
 * This manages a wait list whereby guests register themselves
 * and are notified when a room is available
 */
public class Waitlist implements Subject {
	/* Array list of observers to be notified if a vacancy if available */
	private ArrayList<Observer> observers;
	/* Create an instance of MotelSingleton */
	private static MotelSingleton roachMotel = MotelSingleton.getInstance();

	/**
	 * Creates an array list to store observers.
	 */
	public Waitlist() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Adds a registered observer to the array list.
	 */
	public void addObserver(Observer o) {
		observers.add(o);
	}

	/**
	 * Removes all registered observers from the array list.
	 */
	public void removeObservers() {
		for(int i = 0; i < observers.size(); i++)
			observers.remove(i);
		System.out.println("\nAll observers have been removed from the wait list.");
	}

	/**
	 * Notifies all registered observers from the array list.
	 */
	public void notifyObservers() {
		String motel = roachMotel.getMotelName();
		for (int i = 0; i < observers.size(); i++) {
			Observer obs = observers.get(i);
			obs.update(motel);
		}
		removeObservers();
	}

}
