/**
 * Subject.java
 *
 * Objects implementing this interface allow observers
 * to register with it. When this object changes state,
 * it notifies all registered observers.
 */
public interface Subject {

	/**
	 * Allows an observer to register with the subject
	 * @param o Observer to be added
	 */
	public void addObserver( Observer o );

	/**
	 * Removes all observers
	 */
	public void removeObservers();

	/**
	 * Notifies all registered observers when its state changes
	 */
	public void notifyObservers();
}
